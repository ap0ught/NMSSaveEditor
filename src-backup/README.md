# NMS Save Editor - Decompiled Source Code

This directory contains the decompiled source code of the No Man's Sky Save Editor, extracted using Vineflower decompiler from the original JAR file.

## Project Structure

- `src/` - Source code directory
  - `nomanssave/` - Main application package
  - `com/formdev/flatlaf/` - FlatLaf Look and Feel library
  - `net/` - Additional libraries
- `pom.xml` - Maven project configuration
- `NMSSaveEditor.code-workspace` - VS Code workspace configuration

## Known Issues

The decompiled code has several issues that prevent clean compilation:

1. **Java Keyword Conflicts**: Some variable/method names use Java keywords (e.g., `do`, `if`)
   - Partially fixed: `do` class renamed to `DoClass`, `do()` method to `doMethod()`
   - Remaining: Various other keyword conflicts

2. **Obfuscated Code**: The original JAR was obfuscated, resulting in:
   - Single-letter class names (A.java, B.java, etc.)
   - Cryptic variable names
   - Reduced readability

3. **Generic Type Erasure**: Some generic types are not properly preserved
4. **Missing Dependencies**: Some external libraries may not be included

## Working with the Source

### Using VS Code
1. Open the `NMSSaveEditor.code-workspace` file in VS Code
2. Install recommended Java extensions
3. The project is configured as a Maven project

### Building
```bash
# Clean build (may have compilation errors)
mvn clean compile

# The original JAR is still functional and can be run:
java -jar NMSSaveEditor.jar
```

## Development Notes

- The main application class is `nomanssave.Application`
- Version is defined as `1.19.0` in `Application.java`
- This is primarily intended to make the codebase browsable and editable
- For actual development, manual fixes to compilation errors would be needed

## Original Functionality

The original JAR file remains functional and includes:
- No Man's Sky save file editing
- GUI interface with tabs for different game elements
- Support for PC/Xbox/PS4 save files
- Various inventory and progression editing features