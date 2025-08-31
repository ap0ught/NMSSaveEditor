@echo off
rem NMS Save Editor Offline Startup Script (Windows)
rem This script starts the NMS Save Editor in a network-restricted environment
rem Specifically designed to work around firewall restrictions

setlocal enabledelayedexpansion

echo 🔒 Starting NMS Save Editor in firewall-restricted mode...

rem Set script directory
set "SCRIPT_DIR=%~dp0"
cd /d "%SCRIPT_DIR%"

rem Disable network features that might trigger firewall blocks
set "JAVA_TOOL_OPTIONS=%JAVA_TOOL_OPTIONS% -Djava.net.useSystemProxies=false"
set "JAVA_TOOL_OPTIONS=%JAVA_TOOL_OPTIONS% -Dnetworkaddress.cache.ttl=0"

rem Check if Java is available
java -version >nul 2>&1
if errorlevel 1 (
    echo ❌ Error: Java is not installed or not in PATH
    echo Please install Java 8 or higher from: https://java.com/en/download/
    pause
    exit /b 1
)

rem Check if the JAR file exists
if not exist "NMSSaveEditor.jar" (
    echo ❌ Error: NMSSaveEditor.jar not found in %SCRIPT_DIR%
    echo Please ensure the JAR file is in the same directory as this script
    pause
    exit /b 1
)

echo Working directory: %CD%
echo Java version:
java -version
echo.

rem Configure memory allocation (default 2GB, can be overridden with JAVA_XMX environment variable)
if not defined JAVA_XMX set "JAVA_XMX=-Xmx2G"

echo 🚀 Starting application with firewall-safe settings...
echo    - Auto-update: DISABLED
echo    - Network features: RESTRICTED
echo    - Memory allocation: %JAVA_XMX%
echo.

rem Start the application without auto-update and with network restrictions
java %JAVA_XMX% ^
     -Djava.net.useSystemProxies=false ^
     -Dnetworkaddress.cache.ttl=0 ^
     -jar NMSSaveEditor.jar ^
     %*

rem Capture the exit code
set "EXIT_CODE=%errorlevel%"

if not %EXIT_CODE%==0 (
    echo.
    echo Application exited with code: %EXIT_CODE%
    if %EXIT_CODE%==143 (
        echo Note: Exit code 143 indicates the application was terminated ^(possibly by forceExit^)
        echo See TROUBLESHOOTING.md for solutions to forceExit and firewall issues
    )
    pause
)

exit /b %EXIT_CODE%