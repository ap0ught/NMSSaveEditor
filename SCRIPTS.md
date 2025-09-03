# NMS Save Editor - Available Scripts

This document provides an overview of all scripts available in the repository and their usage.

## Application Startup Scripts

### Standard Mode (Recommended)

**Linux/macOS:**
```bash
./start-editor.sh
```

**Windows:**
```batch
start-editor.bat
```

These scripts start the NMS Save Editor with optimized settings:
- Configurable memory allocation (default 2GB, set with `JAVA_XMX` environment variable)
- Disables auto-update to prevent forceExit issues
- Provides error code reporting

### Firewall-Restricted Mode

**Linux/macOS:**
```bash
./start-editor-offline.sh
```

**Windows:**
```batch
start-editor-offline.bat
```

These scripts are designed for environments with strict firewall restrictions:
- Disables network features that can cause conflicts
- Prevents problematic Java system proxy detection
- Avoids DNS caching issues
- Safe for corporate networks and restricted CI environments

## Validation and Testing Scripts

### Binary Application Validation

```bash
./validate-binary.sh
```

Comprehensive test suite that validates:
- Application launch and GUI functionality
- Memory configuration testing
- Java version compatibility
- File system operations
- Screenshots and visual validation

**Requirements:**
- Java 8+ installed
- Xvfb for headless testing
- At least 60 seconds timeout for proper validation

### Automated Quick Validation

```bash
./automated-validation.sh
```

Quick validation script for CI/CD integration:
- Basic application launch test
- High memory configuration test
- Log file generation test

Perfect for GitHub Actions or other automated testing environments.

## Development Scripts

### Decompile Error Analysis

```bash
./scripts/check_decompile_errors.sh
```

Analyzes the decompiled source code to identify and catalog:
- Files with decompilation errors
- Types of decompilation issues
- Most problematic files
- Compilation error summary

Useful for understanding the state of the decompiled codebase.

### Branch Protection Setup

```bash
./scripts/setup-branch-protection.sh
```

Interactive script for setting up GitHub branch protection rules:
- Checks prerequisites (GitHub CLI authentication)
- Applies protection rules to master branch
- Shows before/after status
- Provides fallback options

## Usage Examples

### Basic Application Testing
```bash
# Quick test that the application works
./automated-validation.sh

# Full comprehensive validation
./validate-binary.sh
```

### Development Workflow
```bash
# Start the application for testing
./start-editor.sh

# For restricted environments
./start-editor-offline.sh

# Analyze decompilation quality
./scripts/check_decompile_errors.sh
```

### CI/CD Integration
```bash
# In GitHub Actions or similar
export DISPLAY=:99
Xvfb :99 -screen 0 1024x768x24 &
./automated-validation.sh
```

## Script Dependencies

### Required for All Scripts
- Java 8+ (Java 8 recommended, Java 11 and 17 also work)
- NMSSaveEditor.jar file present

### Required for GUI Testing
- X11 display environment (or Xvfb for headless)
- `scrot` for screenshot capture (validation scripts)

### Required for Development Scripts
- Maven (for compilation testing)
- GitHub CLI (for branch protection setup)

## Notes

- **Timing**: Allow adequate time for application startup (10-15 seconds minimum)
- **Memory**: Use `-Xmx4G` for large save files
- **Firewall**: Use offline scripts in restricted network environments
- **Permissions**: Ensure scripts are executable (`chmod +x script-name.sh`)