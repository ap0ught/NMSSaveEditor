#!/usr/bin/env bash

# NMS Save Editor Startup Script
# This script starts the NMS Save Editor without auto-update to avoid forceExit issues

# Set script directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Check if Java is available
if ! command -v java &> /dev/null; then
    echo "Error: Java is not installed or not in PATH"
    echo "Please install Java 8 or higher from: https://java.com/en/download/"
    exit 1
fi

# Check if the JAR file exists
JAR_FILE="$SCRIPT_DIR/NMSSaveEditor.jar"
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: NMSSaveEditor.jar not found in $SCRIPT_DIR"
    echo "Please ensure the JAR file is in the same directory as this script"
    exit 1
fi

# Change to the script directory
cd "$SCRIPT_DIR"

echo "Starting NMS Save Editor..."
echo "Working directory: $PWD"
echo "Java version:"
java -version

# Start the application without auto-update to prevent forceExit issues
# Use configurable memory allocation for large save files
JAVA_XMX_OPTION="${JAVA_XMX:--Xmx2G}"
java "$JAVA_XMX_OPTION" -jar NMSSaveEditor.jar "$@"

# Capture the exit code
EXIT_CODE=$?

if [ $EXIT_CODE -ne 0 ]; then
    echo ""
    echo "Application exited with code: $EXIT_CODE"
    if [ $EXIT_CODE -eq 143 ]; then
        echo "Note: Exit code 143 indicates the application was terminated (possibly by forceExit)"
        echo "See TROUBLESHOOTING.md for solutions to forceExit issues"
    fi
fi

exit $EXIT_CODE