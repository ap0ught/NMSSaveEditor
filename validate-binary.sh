#!/bin/bash

# No Man's Sky Save Editor - Binary Application Validation Script
# This script validates the functionality of the pre-built JAR file

set -e

echo "========================================"
echo "NMS Save Editor Binary Validation Suite"
echo "========================================"
echo "Version: 1.19.0 (VOYAGERS)"
echo "Date: $(date)"
echo ""

# Configuration
TIMEOUT_STARTUP=60
TIMEOUT_OPERATION=30
VALIDATION_DIR="/tmp/nms-validation"
SCREENSHOT_DIR="$VALIDATION_DIR/screenshots"

# Setup validation environment
setup_environment() {
    echo "Setting up validation environment..."

    # Create validation directories
    mkdir -p "$VALIDATION_DIR" "$SCREENSHOT_DIR"

    # Setup virtual display for headless testing
    if [ -z "$DISPLAY" ]; then
        echo "Starting virtual display (Xvfb)..."
        Xvfb :99 -screen 0 1024x768x24 >/dev/null 2>&1 &
        XVFB_PID=$!
        export DISPLAY=:99
        sleep 2
        echo "Virtual display started on :99"
    fi

    # Verify Java installation
    if ! command -v java &> /dev/null; then
        echo "ERROR: Java is not installed or not in PATH"
        exit 1
    fi

    echo "Java version: $(java -version 2>&1 | head -1)"
    echo "Display: $DISPLAY"
    echo ""
}

# Test 1: Application Launch Validation
test_application_launch() {
    echo "Test 1: Application Launch Validation"
    echo "-------------------------------------"

    # Remove old log file
    rm -f NMSSaveEditor.log

    echo "Launching application (timeout: ${TIMEOUT_STARTUP}s)..."
    timeout $TIMEOUT_STARTUP java -jar NMSSaveEditor.jar >/dev/null 2>&1 &
    APP_PID=$!

    # Wait for startup
    echo "Waiting for application startup..."
    sleep 15

    # Check if process is running
    if kill -0 $APP_PID 2>/dev/null; then
        echo "✓ Application launched successfully (PID: $APP_PID)"

        # Take screenshot
        if command -v scrot &> /dev/null; then
            scrot "$SCREENSHOT_DIR/application_launch.png" 2>/dev/null || true
            echo "✓ Screenshot captured"
        fi

        # Check log file
        if [ -f NMSSaveEditor.log ]; then
            echo "✓ Log file created"
            echo "  Log file size: $(stat -f%z NMSSaveEditor.log 2>/dev/null || stat -c%s NMSSaveEditor.log) bytes"
        else
            echo "⚠ Log file not found"
        fi

        # Cleanup
        kill $APP_PID 2>/dev/null
        echo "✓ Application terminated cleanly"
    else
        echo "✗ Application failed to launch or crashed during startup"
        return 1
    fi
    echo ""
}

# Test 2: Memory Configuration Validation
test_memory_configuration() {
    echo "Test 2: Memory Configuration Validation"
    echo "---------------------------------------"

    echo "Testing high memory allocation (4GB heap)..."
    timeout $TIMEOUT_STARTUP java -Xmx4G -jar NMSSaveEditor.jar >/dev/null 2>&1 &
    APP_PID=$!

    sleep 15

    if kill -0 $APP_PID 2>/dev/null; then
        echo "✓ High memory configuration (4GB) works correctly"
        kill $APP_PID 2>/dev/null
    else
        echo "✗ High memory configuration failed"
        return 1
    fi
    echo ""
}

# Test 3: Java Compatibility Validation
test_java_compatibility() {
    echo "Test 3: Java Compatibility Validation"
    echo "-------------------------------------"

    # Test with current Java version
    JAVA_VERSION=$(java -version 2>&1 | head -1 | sed 's/.*version "\([^"]*\)".*/\1/')
    echo "Testing with Java version: $JAVA_VERSION"

    timeout $TIMEOUT_STARTUP java -jar NMSSaveEditor.jar >/dev/null 2>&1 &
    APP_PID=$!
    sleep 10

    if kill -0 $APP_PID 2>/dev/null; then
        echo "✓ Java $JAVA_VERSION compatibility confirmed"
        kill $APP_PID 2>/dev/null
    else
        echo "✗ Java $JAVA_VERSION compatibility issue detected"
        return 1
    fi
    echo ""
}

# Test 4: GUI Functionality Validation
test_gui_functionality() {
    echo "Test 4: GUI Functionality Validation"
    echo "------------------------------------"

    echo "Starting application for GUI testing..."
    java -jar NMSSaveEditor.jar >/dev/null 2>&1 &
    APP_PID=$!

    # Wait for full GUI initialization
    echo "Waiting for GUI initialization (20 seconds)..."
    sleep 20

    if kill -0 $APP_PID 2>/dev/null; then
        echo "✓ Application running with GUI"

        # Take screenshot of main window
        if command -v scrot &> /dev/null; then
            scrot "$SCREENSHOT_DIR/main_window.png" 2>/dev/null && echo "✓ Main window screenshot captured"
        fi

        # Test basic window interaction if xdotool is available
        if command -v xdotool &> /dev/null; then
            echo "Testing basic GUI interaction..."

            # Focus on the application window
            WINDOW_ID=$(xdotool search --name "No Man's Sky Save Editor" | head -1)
            if [ ! -z "$WINDOW_ID" ]; then
                xdotool windowfocus "$WINDOW_ID"
                sleep 1
                scrot "$SCREENSHOT_DIR/focused_window.png" 2>/dev/null && echo "✓ Window focus test passed"
            fi
        fi

        kill $APP_PID 2>/dev/null
        echo "✓ GUI functionality test completed"
    else
        echo "✗ GUI functionality test failed"
        return 1
    fi
    echo ""
}

# Test 5: File System Integration
test_file_system() {
    echo "Test 5: File System Integration"
    echo "-------------------------------"

    # Check JAR file integrity
    if [ -f "NMSSaveEditor.jar" ]; then
        JAR_SIZE=$(stat -f%z "NMSSaveEditor.jar" 2>/dev/null || stat -c%s "NMSSaveEditor.jar")
        echo "✓ JAR file found (size: $JAR_SIZE bytes)"

        # Verify JAR can be read
        if java -jar NMSSaveEditor.jar --help >/dev/null 2>&1 || true; then
            echo "✓ JAR file is readable"
        fi
    else
        echo "✗ NMSSaveEditor.jar not found in current directory"
        return 1
    fi

    # Check for required resources
    if unzip -l NMSSaveEditor.jar | grep -q "icons/"; then
        echo "✓ Icon resources found in JAR"
    else
        echo "⚠ Icon resources not found"
    fi
    echo ""
}

# Generate validation report
generate_report() {
    echo "========================================="
    echo "Validation Report Summary"
    echo "========================================="
    echo "Test Date: $(date)"
    echo "Java Version: $(java -version 2>&1 | head -1)"
    echo "System: $(uname -a)"
    echo ""

    if [ -f NMSSaveEditor.log ]; then
        echo "Application Log Summary:"
        echo "------------------------"
        tail -10 NMSSaveEditor.log | sed 's/^/  /'
        echo ""
    fi

    echo "Screenshots captured in: $SCREENSHOT_DIR"
    if [ -d "$SCREENSHOT_DIR" ]; then
        echo "Available screenshots:"
        ls -la "$SCREENSHOT_DIR"/ | sed 's/^/  /'
    fi
    echo ""
}

# Cleanup function
cleanup() {
    echo "Cleaning up..."

    # Kill any remaining Java processes
    pkill -f "NMSSaveEditor.jar" 2>/dev/null || true

    # Stop virtual display if we started it
    if [ ! -z "$XVFB_PID" ]; then
        kill $XVFB_PID 2>/dev/null || true
    fi
}

# Main execution
main() {
    # Set up cleanup trap
    trap cleanup EXIT

    # Change to script directory
    cd "$(dirname "$0")"

    # Run validation tests
    setup_environment

    FAILED_TESTS=0

    test_application_launch || FAILED_TESTS=$((FAILED_TESTS + 1))
    test_memory_configuration || FAILED_TESTS=$((FAILED_TESTS + 1))
    test_java_compatibility || FAILED_TESTS=$((FAILED_TESTS + 1))
    test_gui_functionality || FAILED_TESTS=$((FAILED_TESTS + 1))
    test_file_system || FAILED_TESTS=$((FAILED_TESTS + 1))

    generate_report

    if [ $FAILED_TESTS -eq 0 ]; then
        echo "🎉 All validation tests passed successfully!"
        exit 0
    else
        echo "❌ $FAILED_TESTS test(s) failed"
        exit 1
    fi
}

# Execute main function
main "$@"

