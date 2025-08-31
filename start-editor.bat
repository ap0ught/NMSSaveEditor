@echo off
REM NMS Save Editor Startup Script for Windows
REM This script starts the NMS Save Editor without auto-update to avoid forceExit issues

setlocal

REM Set script directory
set "SCRIPT_DIR=%~dp0"

REM Check if Java is available
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java 8 or higher from: https://java.com/en/download/
    pause
    exit /b 1
)

REM Check if the JAR file exists
set "JAR_FILE=%SCRIPT_DIR%NMSSaveEditor.jar"
if not exist "%JAR_FILE%" (
    echo Error: NMSSaveEditor.jar not found in %SCRIPT_DIR%
    echo Please ensure the JAR file is in the same directory as this script
    pause
    exit /b 1
)

REM Change to the script directory
cd /d "%SCRIPT_DIR%"

echo Starting NMS Save Editor...
echo Working directory: %CD%
echo Java version:
java -version

REM Start the application without auto-update to prevent forceExit issues
REM Use increased memory allocation for large save files
java -Xmx4G -jar NMSSaveEditor.jar %*

REM Capture the exit code
set EXIT_CODE=%ERRORLEVEL%

if %EXIT_CODE% neq 0 (
    echo.
    echo Application exited with code: %EXIT_CODE%
    if %EXIT_CODE% equ 143 (
        echo Note: Exit code 143 indicates the application was terminated ^(possibly by forceExit^)
        echo See TROUBLESHOOTING.md for solutions to forceExit issues
    )
    pause
)

exit /b %EXIT_CODE%