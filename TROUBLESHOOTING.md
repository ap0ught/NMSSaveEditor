# Troubleshooting Guide

## ForceExit Issue - Application Shutting Down

### Problem
The NMS Save Editor may forcefully exit with the message "forceExit is shutting down the process" when auto-update features are enabled and network connections are blocked by firewalls or security policies.

### Symptoms
- Application starts normally but exits unexpectedly
- Exit code 143 (terminated by SIGTERM)
- Network connection warnings in logs
- Occurs particularly when using `-autoupdate` command line argument

### Root Cause
The auto-update feature attempts to make network connections to check for updates. When these connections are blocked by firewall rules or network restrictions, the application may perform a forced exit rather than gracefully handling the network failure.

### Solutions

#### Solution 1: Avoid Auto-Update Flag
**Recommended for most users**

Do not use the `-autoupdate` command line argument when starting the application:

```bash
# Instead of:
java -jar NMSSaveEditor.jar -autoupdate

# Use:
java -jar NMSSaveEditor.jar
```

#### Solution 2: Use Startup Script
Use the provided startup script that excludes the problematic auto-update flag:

**For Linux/macOS:**
```bash
./start-editor.sh
```

**For Windows:**
```batch
start-editor.bat
```

#### Solution 3: Manual Updates
Check for updates manually by:
1. Visiting the [GitHub releases page](https://github.com/ap0ught/NMSSaveEditor/releases)
2. Downloading the latest version when available
3. Replacing your current installation

#### Solution 4: Network Configuration (Advanced)
If you need auto-update functionality, ensure your firewall/network allows connections to:
- GitHub servers for update checks
- Any update distribution servers used by the application

Contact your network administrator if you're in a corporate environment.

### Verification
After applying a solution:
1. Start the application normally
2. Verify it loads the main interface without exiting
3. Test basic functionality like opening the File menu

### Additional Notes
- The application works perfectly for save editing without auto-update
- This issue only affects the update mechanism, not core functionality
- Manual updates are often safer and more reliable anyway

### Related Information
- See [README.md](README.md) for installation instructions
- See [FAQ.md](FAQ.md) for general usage questions
- This resolves GitHub issue #11

## GitHub Actions Firewall Issues

### Problem
GitHub Actions workflows may encounter firewall restrictions when accessing certain Ubuntu repositories (particularly `esm.ubuntu.com`) during dependency installation.

### Symptoms
- Workflow failures during Java setup or package installation
- DNS resolution errors for `esm.ubuntu.com`
- Timeout errors in `/usr/lib/apt/methods/https`
- Failed GitHub Actions runs with network-related errors

### Root Cause
Some corporate firewalls or network policies block access to Ubuntu's Extended Security Maintenance (ESM) repositories, which are accessed during package installation operations.

### Solutions

#### Solution 1: Use Pre-installed Tools (Recommended)
The GitHub Actions workflows have been configured with fallback mechanisms to use pre-installed Java when network access is restricted.

#### Solution 2: Configure Allowlist
Repository administrators can add the following domains to their Copilot coding agent allowlist:
- `esm.ubuntu.com`
- `security.ubuntu.com`
- `archive.ubuntu.com`

For detailed configuration guidance, see [Copilot coding agent tips](https://gh.io/copilot-coding-agent-tips).

#### Solution 3: Alternative Setup Actions
Use Actions setup steps that run before firewall restrictions are enabled, as suggested in the GitHub Copilot documentation.

### Verification
After applying solutions:
1. Check GitHub Actions logs for successful Java installation
2. Verify CI workflows complete without network errors
3. Monitor for fallback mechanisms being triggered

### Additional Notes
- The CI workflows include automatic fallbacks for network restrictions
- Core application functionality is not affected by these network issues
- Manual local development is unaffected by GitHub Actions firewall restrictions
- For comprehensive firewall solutions, see [Firewall Guide](docs/FIREWALL_GUIDE.md)