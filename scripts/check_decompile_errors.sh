#!/bin/bash

# Script to identify and catalog decompile errors in the NMS Save Editor codebase

echo "=== NMS Save Editor Decompile Error Analysis ==="
echo "Date: $(date)"
echo

# Find all files with decompile errors
echo "1. Files with decompile errors:"
echo "================================"
grep -r "\$VF:" src/ | cut -d: -f1 | sort | uniq -c | sort -nr

echo
echo "2. Detailed decompile error summary:"
echo "===================================="

# Count different types of errors
echo "Total decompile error comments: $(grep -r "\$VF:" src/ | wc -l)"
echo "Files affected: $(grep -r "\$VF:" src/ | cut -d: -f1 | sort | uniq | wc -l)"

echo
echo "3. Error types:"
echo "==============="
echo "Could not inline inconsistent finally blocks: $(grep -r "Could not inline inconsistent finally blocks" src/ | wc -l)"
echo "Couldn't be decompiled (parsing failure): $(grep -r "Couldn't be decompiled" src/ | grep "parsing failure" | wc -l)"

echo
echo "4. Most problematic files (by error count):"
echo "==========================================="
grep -r "\$VF:" src/ | cut -d: -f1 | sort | uniq -c | sort -nr | head -10

echo
echo "5. Methods that couldn't be decompiled:"
echo "======================================"
grep -A1 -B1 "Couldn't be decompiled" src/**/*.java | grep -E "(public|private|protected|void|class|interface)" | head -20

echo
echo "6. Compilation errors check:"
echo "============================"
cd /home/runner/work/NMSSaveEditor/NMSSaveEditor
mvn compile 2>&1 | grep -E "\[ERROR\]" | head -10

echo
echo "Analysis complete."