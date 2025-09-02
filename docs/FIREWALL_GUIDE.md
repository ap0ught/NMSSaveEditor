# Firewall and Network Restrictions Guide

This guide provides solutions for running the NMS Save Editor in environments with firewall restrictions, corporate networks, or when GitHub Actions encounter network blocks.

## Quick Reference - Common Firewall Issues

### 🚨 ESM Repository Access Blocked (Most Common)
**Error Pattern:** `esm.ubuntu.com` DNS blocks, `/usr/lib/apt/methods/https` failures

**Quick Solutions:**
- **GitHub Actions**: Use pre-installed Java fallbacks (already configured in workflows)
- **Local Development**: Use `start-editor-offline.sh` or `start-editor-offline.bat`
- **Administrators**: Add `esm.ubuntu.com` to allowlist ([Copilot coding agent tips](https://gh.io/copilot-coding-agent-tips))

### 🔧 Application Network Issues
**Error Pattern:** ForceExit shutdowns, network connection failures

**Quick Solutions:**
- Avoid `-autoupdate` flag
- Use offline startup scripts
- See [TROUBLESHOOTING.md](TROUBLESHOOTING.md) for detailed guidance

## Common Firewall Issues

### ESM Repository Access Blocked
**Error Pattern:** `esm.ubuntu.com` DNS blocks, `/usr/lib/apt/methods/https` failures

**Root Cause:** Ubuntu's Extended Security Maintenance (ESM) repositories are blocked by corporate firewalls or security policies.

**Impact:** Affects GitHub Actions workflows during Java installation and system updates.

## Quick Solutions

### For Local Development

#### Option 1: Use Firewall-Safe Startup Scripts

**Linux/macOS:**
```bash
./start-editor-offline.sh
```

**Windows:**
```batch
start-editor-offline.bat
```

These scripts configure the application with:
- Disabled network auto-update features
- Firewall-safe Java system properties
- No external network dependencies

#### Option 2: Manual Java Configuration

Add these Java system properties to disable problematic network features:
```bash
java -Djava.net.useSystemProxies=false \
     -Dnetworkaddress.cache.ttl=0 \
     -jar NMSSaveEditor.jar
```

### For GitHub Actions / CI

#### Option 1: Use Modified Workflows
The repository includes firewall-resistant GitHub Actions workflows that:
- Use dependency caching to avoid repeated downloads
- Include fallback mechanisms for network failures
- Set environment variables to prevent ESM access

#### Option 2: Pre-configure Environment
Add these environment variables to your workflow:
```yaml
env:
  DEBIAN_FRONTEND: noninteractive
  ACTIONS_ALLOW_UNSECURE_COMMANDS: false
```

#### Option 3: Configure Network Allowlist
Add these domains to your organization's firewall allowlist:
- `esm.ubuntu.com`
- `security.ubuntu.com`
- `archive.ubuntu.com`
- `api.github.com`

## Technical Details

### Network Operations Disabled
The offline startup scripts disable these potentially problematic Java features:
- System proxy detection
- DNS caching (prevents stale blocked domain caches)
- Auto-update mechanisms
- External connectivity checks

### GitHub Actions Improvements
The CI workflows have been enhanced with:
- Fallback Java detection for pre-installed runtimes
- Graceful handling of network connectivity issues
- Dependency caching to reduce network calls
- Environment configuration to prevent ESM access

## Verification

### Local Testing
1. Start the application using an offline script
2. Verify the main interface loads without network errors
3. Check the application log for any blocked connection attempts

### GitHub Actions Testing
1. Monitor workflow runs for successful completion
2. Check for fallback mechanisms being triggered
3. Verify Java installation succeeds or falls back gracefully

## Troubleshooting

### If Application Still Has Network Issues
1. Check your corporate proxy settings
2. Verify Java installation is complete and functional
3. Try running with explicit network debugging:
   ```bash
   java -Djava.net.debug=all -jar NMSSaveEditor.jar
   ```

### If GitHub Actions Still Fail
1. Check the Actions logs for specific error messages
2. Verify the repository's network allowlist configuration
3. Consider using self-hosted runners with appropriate network access

## Advanced Configuration

### Custom Network Settings
For specific network environments, you can customize the startup scripts:

```bash
# Additional Java network options
export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -Dhttp.proxyHost=your.proxy.com"
export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -Dhttp.proxyPort=8080"
export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -Dhttps.proxyHost=your.proxy.com"
export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -Dhttps.proxyPort=8080"
```

### Repository-Specific Settings
Repository administrators can configure Copilot coding agent settings to allow specific domains and reduce firewall conflicts.

**For GitHub Copilot Enhancement:**
- Configure custom allowlists for blocked domains
- Set up custom instructions for development environment
- See [Copilot coding agent tips](https://gh.io/copilot-coding-agent-tips) for advanced configuration options

## Related Documentation

- [TROUBLESHOOTING.md](TROUBLESHOOTING.md) - General application troubleshooting
- [README.md](README.md) - Installation and setup instructions
- [FAQ.md](FAQ.md) - Frequently asked questions

---

This guide addresses GitHub issue #13 regarding firewall restrictions and `esm.ubuntu.com` access blocks.