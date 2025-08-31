# No Man's Sky Save Editor (NMSSaveEditor)

Always follow these instructions first and fallback to additional search and context gathering only if the information in the instructions is incomplete or found to be in error.

## Critical Understanding

This is a **binary distribution repository** containing pre-built Java application executables, not a source code repository. You cannot build this application from source as no source code is provided. The repository contains:

- Pre-compiled Java JAR file (NMSSaveEditor.jar)
- Self-extracting Windows executable (NMSSaveEditor.exe) 
- Distribution zip (NMSSaveEditor.zip)
- Documentation and screenshots

## Working Effectively

### Java Environment Setup
- **REQUIRED**: Install Java 8 as the primary runtime environment:
  ```bash
  sudo apt-get update && sudo apt-get install -y openjdk-8-jre
  ```
- Alternative: Java 11 and Java 17 also work but Java 8 is recommended per documentation
- **NEVER** attempt to build from source - this repository contains only binaries

### GUI Environment Requirements
- **CRITICAL**: Application requires X11 display environment (GUI application)
- For headless testing, install and run Xvfb:
  ```bash
  sudo apt-get install -y xvfb scrot
  Xvfb :99 -screen 0 1024x768x24 &
  export DISPLAY=:99
  ```

### Running the Application
- **Standard memory**: `java -jar NMSSaveEditor.jar`
- **Large save files**: `java -Xmx4G -jar NMSSaveEditor.jar` (recommended for complex saves)
- **With auto-update**: `java -jar NMSSaveEditor.jar -autoupdate`
- **Startup time**: ~10-15 seconds to initialize. NEVER CANCEL - wait for "Starting Editor..." message
- **Expected startup sequence**:
  ```
  Initializing environment...
  Starting Editor...
  ```

### Known Issues and Expected Behavior
- **Thread-4 NegativeArraySizeException**: This is a known minor exception that occurs during startup but does not prevent normal operation. Document but do not attempt to fix.
- **Memory usage**: Application uses ~150-200MB RAM, can grow with large save files
- **Log file**: Application creates `NMSSaveEditor.log` in working directory

## Validation and Testing

### NEVER CANCEL Operations
- **Application startup**: Takes 10-15 seconds. Set timeout to 60+ seconds minimum
- **Save file loading**: May take 30+ seconds for large/complex saves. NEVER CANCEL
- **GUI operations**: Allow 5-10 seconds for UI updates after clicks

### Required Validation Scenarios
After making any changes to the repository, ALWAYS run these validation steps:

1. **Application Launch Test**:
   ```bash
   export DISPLAY=:99
   cd /home/runner/work/NMSSaveEditor/NMSSaveEditor
   timeout 60 java -jar NMSSaveEditor.jar &
   sleep 15
   scrot /tmp/validation_screenshot.png
   # Verify application window appears and shows main interface
   ```

2. **Memory Configuration Test**:
   ```bash
   timeout 60 java -Xmx4G -jar NMSSaveEditor.jar &
   # Should start without memory errors
   ```

3. **Java Version Compatibility**:
   ```bash
   /usr/lib/jvm/java-8-openjdk-amd64/bin/java -jar NMSSaveEditor.jar &
   # Should start normally with Java 8
   ```

4. **Log File Generation**:
   ```bash
   # After running application, verify log file exists:
   ls -la NMSSaveEditor.log
   # Should contain startup messages and system info
   ```

### Manual Testing Requirements
- **ALWAYS** take screenshots of the running application to verify GUI functionality
- Test application startup and ensure main window displays properly
- Verify log file contains expected startup sequence without fatal errors
- Application should remain responsive (not frozen) after startup

## Repository Structure and Key Files

### Documentation Files
- `README.md` - Installation instructions and feature overview
- `FAQ.md` - Common issues and solutions for save editing
- `CHANGELOG.md` - Version history and update notes
- `VERSION.txt` - Current version (1.19.0)

### Application Files
- `NMSSaveEditor.jar` - Main Java application (70MB)
- `NMSSaveEditor.exe` - Self-extracting Windows version (66MB)
- `NMSSaveEditor.zip` - Manual download distribution (69MB)
- `zipcontents.png` - Screenshot showing zip file contents

### Application Directories
- `screenshots/` - UI screenshots demonstrating features:
  - `main.png` - Main interface
  - `exosuit.png` - Player inventory editing
  - `ships.png` - Ship management
  - `freighter.png` - Freighter editing
  - `companions.png` - Pet/companion management
  - `base.png` - Base building tools
  - `jsoneditor.png` - Raw save file JSON editing
  - `darkmode.png` - Dark theme option

## Application Features and Testing Focus

### Core Functionality
- **Save File Editor**: Edits No Man's Sky save files for PC/Xbox/PS4
- **Inventory Management**: Modify player equipment, ships, freighters
- **Currency Editing**: Change Units, Nanites, Quicksilver
- **Progress Modification**: Milestones, discoveries, reputation
- **JSON Editor**: Advanced raw save file editing

### Key User Workflows to Test
1. **Application Launch**: Verify main window appears with menu bar and tabs
2. **File Dialog**: Check that file open dialogs work (even without save files)
3. **Tab Navigation**: Ensure all tabs (Exosuit, Ships, Freighter, etc.) are accessible
4. **Settings Access**: Verify Look & Feel and other settings can be accessed
5. **Help/About**: Check that application info displays correctly

## Development Constraints

### What You CAN Do
- Update documentation files (README.md, FAQ.md, CHANGELOG.md)
- Add new screenshots to document features
- Test and validate application functionality
- Create configuration or supporting files
- Update version information in VERSION.txt

### What You CANNOT Do
- Modify the Java application code (no source available)
- Build the application from source
- Fix Java exceptions or bugs in the application
- Change application behavior or add new features to the JAR

### CI/CD Information
- **No GitHub Actions**: This repository has no automated build/test workflows
- **No Build System**: No Maven, Gradle, or Ant build files present
- **Manual Distribution**: Updates are released by manually committing new binaries
- **Version Control**: Only tracks final distribution files, not source code changes

## Common Commands Reference

### Environment Setup
```bash
# Install Java 8 (recommended)
sudo apt-get update && sudo apt-get install -y openjdk-8-jre

# Setup headless GUI environment
sudo apt-get install -y xvfb scrot
Xvfb :99 -screen 0 1024x768x24 &
export DISPLAY=:99
```

### Application Testing
```bash
# Basic application test
cd /home/runner/work/NMSSaveEditor/NMSSaveEditor
java -jar NMSSaveEditor.jar &
sleep 15
scrot /tmp/app_test.png

# Memory stress test
java -Xmx4G -jar NMSSaveEditor.jar &

# Check application logs
cat NMSSaveEditor.log
```

### Screenshot Validation
```bash
# Take application screenshot
export DISPLAY=:99
scrot /tmp/validation_screenshot.png
ls -la /tmp/validation_screenshot.png
```

## Timing Expectations and Timeouts

- **Application startup**: 10-15 seconds (set 60+ second timeouts)
- **GUI response**: 2-5 seconds for menu actions
- **File operations**: 5-30 seconds depending on save file size
- **Memory allocation**: Instantaneous with proper Java heap settings

**CRITICAL**: Always use appropriate timeouts for GUI operations. NEVER CANCEL application startup or file operations prematurely.