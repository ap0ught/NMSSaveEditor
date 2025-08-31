#!/bin/bash
# Build script for NMS Save Editor

set -e

echo "Building NMS Save Editor..."

# Create build directory
mkdir -p build

# Try to compile the source code
echo "Compiling source code..."
if javac -cp "src" -d build $(find src -name "*.java") 2>/dev/null; then
    echo "Source compilation successful!"
    
    # Create jar with manifest
    echo "Creating JAR file..."
    cp -r META-INF build/
    cd build
    jar cfm ../NMSSaveEditor-compiled.jar META-INF/MANIFEST.MF .
    cd ..
    
    echo "Build complete! JAR created as NMSSaveEditor-compiled.jar"
else
    echo "Source compilation failed due to decompilation issues."
    echo "This is expected - the decompiled code needs manual fixes."
    echo ""
    echo "The original NMSSaveEditor.jar is still functional."
    echo "To use the application, run: java -jar NMSSaveEditor.jar"
    echo ""
    echo "If you want to edit the source code:"
    echo "1. Fix the Java keyword conflicts in the decompiled code"
    echo "2. Run this script again"
    echo ""
    echo "Common issues to fix:"
    echo "- Rename class 'do' to something else (e.g., 'DoHandler')"
    echo "- Fix method names that use Java keywords"
    echo "- Fix enum constant issues in net.jpountz packages"
fi