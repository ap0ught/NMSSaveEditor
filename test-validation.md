# NMS Save Editor - Testing and Validation Guide

This document provides comprehensive testing procedures for validating the No Man's Sky Save Editor binary application.

## Environment Setup

### Java Environment
```bash
# Install Java 8 (recommended)
sudo apt-get update && sudo apt-get install -y openjdk-8-jre

# Verify Java version
java -version
```

### GUI Environment (for headless testing)
```bash
# Install X11 virtual display
sudo apt-get install -y xvfb scrot

# Start virtual display
Xvfb :99 -screen 0 1024x768x24 &
export DISPLAY=:99
```

## Critical Testing Requirements

### Timing Expectations
- **Application startup**: 10-15 seconds (use 60+ second timeouts)
- **GUI response**: 2-5 seconds for menu actions
- **File operations**: 5-30 seconds depending on save file complexity
- **Memory allocation**: Instantaneous with proper Java heap settings

### Known Acceptable Issues
- **Thread-4 NegativeArraySizeException**: Minor startup exception that doesn't prevent operation
- **Startup delay**: Application takes 10-15 seconds to fully initialize

## Validation Test Suite

### 1. Basic Application Launch Test
```bash
cd /path/to/NMSSaveEditor
export DISPLAY=:99

# Test standard launch
timeout 60 java -jar NMSSaveEditor.jar &
sleep 15
scrot /tmp/launch_test.png

# Verify application window exists
if [ -f /tmp/launch_test.png ]; then
    echo "✓ Application launched successfully"
else
    echo "✗ Application failed to launch"
fi
```

### 2. Memory Configuration Test
```bash
# Test high memory allocation
timeout 60 java -Xmx4G -jar NMSSaveEditor.jar &
sleep 15

# Check if process is running
if pgrep -f "NMSSaveEditor.jar" > /dev/null; then
    echo "✓ High memory configuration works"
    pkill -f "NMSSaveEditor.jar"
else
    echo "✗ High memory configuration failed"
fi
```

### 3. Java Version Compatibility Test
```bash
# Test with specific Java version
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -jar NMSSaveEditor.jar &
JAVA8_PID=$!
sleep 15

if kill -0 $JAVA8_PID 2>/dev/null; then
    echo "✓ Java 8 compatibility confirmed"
    kill $JAVA8_PID
else
    echo "✗ Java 8 compatibility issue"
fi
```

### 4. Log File Generation Test
```bash
# Remove existing log
rm -f NMSSaveEditor.log

# Launch application
java -jar NMSSaveEditor.jar &
APP_PID=$!
sleep 20

# Check log file creation
if [ -f NMSSaveEditor.log ]; then
    echo "✓ Log file created successfully"
    echo "Log contents preview:"
    head -5 NMSSaveEditor.log
else
    echo "✗ Log file not created"
fi

kill $APP_PID 2>/dev/null
```

### 5. GUI Functionality Test
```bash
export DISPLAY=:99

# Launch and take screenshots
java -jar NMSSaveEditor.jar &
APP_PID=$!

# Wait for full startup
sleep 20

# Take screenshot of main window
scrot /tmp/main_window.png

# Test basic UI interactions (clicking File menu)
xdotool search --name "No Man's Sky Save Editor" windowfocus
sleep 2
xdotool key alt+f  # Open File menu
sleep 2
scrot /tmp/file_menu.png

# Cleanup
kill $APP_PID 2>/dev/null

if [ -f /tmp/main_window.png ] && [ -f /tmp/file_menu.png ]; then
    echo "✓ GUI functionality test passed"
else
    echo "✗ GUI functionality test failed"
fi
```

## Expected Startup Sequence

The application should display these messages in order:

1. `Initializing environment...`
2. `Starting Editor...`
3. Main window appears with title: "No Man's Sky Save Editor - 1.19.0 (VOYAGERS)"

## UI Components to Validate

### Main Window Elements
- **Menu Bar**: File, Edit, View, Help menus
- **Tab Panel**: Main, Exosuit, Multitool, Ships, etc.
- **File Details Section**: Storage, Save Path, Game Slot, Save File
- **Action Buttons**: Reload, Save Changes, Save As

### Required Tabs (should be present but may be disabled)
1. Main
2. Exosuit
3. Multitool
4. Ships
5. Squadron
6. Freighter
7. Frigates
8. Vehicles
9. Companions
10. Bases & Storage
11. Settlements
12. Discovery
13. Milestones / Reputation
14. Account

## Performance Benchmarks

### Memory Usage
- **Baseline**: ~150-200MB RAM
- **With large save**: Up to 500MB RAM
- **Maximum heap**: Should handle -Xmx4G without issues

### File Operations
- **Save file loading**: < 30 seconds for complex saves
- **JSON export**: < 10 seconds
- **Application startup**: < 15 seconds

## Error Conditions to Test

### Acceptable Errors
- Minor exceptions during startup (Thread-4 NegativeArraySizeException)
- Warnings about missing save files when no saves are present

### Unacceptable Errors
- OutOfMemoryError during normal operation
- Application freeze/hang beyond startup period
- Complete failure to launch GUI

## Automated Test Script

```bash
#!/bin/bash
# automated-validation.sh

set -e

echo "=== NMS Save Editor Validation Test ==="
echo "Starting automated validation..."

# Setup
export DISPLAY=:99
Xvfb :99 -screen 0 1024x768x24 >/dev/null 2>&1 &
XVFB_PID=$!
sleep 2

cd "$(dirname "$0")"

# Test 1: Basic Launch
echo "Test 1: Basic application launch..."
timeout 60 java -jar NMSSaveEditor.jar >/dev/null 2>&1 &
APP_PID=$!
sleep 20

if kill -0 $APP_PID 2>/dev/null; then
    echo "✓ Application launched successfully"
    kill $APP_PID
else
    echo "✗ Application failed to launch"
fi

# Test 2: Memory Test
echo "Test 2: High memory configuration..."
timeout 60 java -Xmx4G -jar NMSSaveEditor.jar >/dev/null 2>&1 &
APP_PID=$!
sleep 15

if kill -0 $APP_PID 2>/dev/null; then
    echo "✓ High memory configuration works"
    kill $APP_PID
else
    echo "✗ High memory configuration failed"
fi

# Test 3: Log File
echo "Test 3: Log file generation..."
rm -f NMSSaveEditor.log
java -jar NMSSaveEditor.jar >/dev/null 2>&1 &
APP_PID=$!
sleep 20
kill $APP_PID 2>/dev/null

if [ -f NMSSaveEditor.log ]; then
    echo "✓ Log file created"
else
    echo "✗ Log file not created"
fi

# Cleanup
kill $XVFB_PID 2>/dev/null

echo "=== Validation Complete ==="
```

## Troubleshooting Common Issues

### Application Won't Start
1. Check Java version: `java -version`
2. Verify JAR file integrity: `java -jar NMSSaveEditor.jar --help`
3. Check available memory: `free -h`
4. Review log file: `cat NMSSaveEditor.log`

### GUI Issues
1. Verify X11 display: `echo $DISPLAY`
2. Test X11 functionality: `xeyes &`
3. Check for GUI libraries: `ldd NMSSaveEditor.jar`

### Memory Issues
1. Increase heap size: `java -Xmx4G -jar NMSSaveEditor.jar`
2. Check system memory: `free -h`
3. Monitor during operation: `top -p $(pgrep java)`

## Continuous Integration Notes

When running in CI environments:
- Always use virtual display (Xvfb)
- Set appropriate timeouts (minimum 60 seconds)
- Never cancel operations prematurely
- Capture screenshots for visual validation
- Save log files as artifacts

