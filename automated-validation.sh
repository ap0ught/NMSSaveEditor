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