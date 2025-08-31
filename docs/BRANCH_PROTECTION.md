# Branch Protection Setup Guide

This guide explains how to protect the master branch of the NMSSaveEditor repository to prevent force pushes, deletions, and ensure proper code review processes.

## Overview

Branch protection rules help maintain code quality and prevent accidental damage to the main branch. The master branch should be protected with the following rules:

- **Prevent force pushes**: Blocks force pushing to the master branch
- **Prevent deletions**: Blocks deletion of the master branch  
- **Require pull request reviews**: Ensures code changes are reviewed before merging
- **Require status checks**: Ensures CI/CD checks pass before merging
- **Dismiss stale reviews**: Automatically dismisses outdated reviews when new commits are pushed

## Setup Methods

### Method 1: Automated Setup via GitHub Actions (Recommended)

The repository includes a GitHub Actions workflow that automatically sets up branch protection:

1. **Automatic trigger**: The workflow runs when changes are pushed to the master branch
2. **Manual trigger**: You can manually run the workflow from the Actions tab

**To manually trigger:**
1. Go to the [Actions tab](../../actions) in GitHub
2. Select "Setup Branch Protection" workflow
3. Click "Run workflow" 
4. Select the master branch and click "Run workflow"

### Method 2: Script-based Setup

Use the provided script to set up branch protection via GitHub CLI:

```bash
# Make sure GitHub CLI is installed and you're authenticated
gh auth login

# Run the setup script
./scripts/setup-branch-protection.sh
```

The script will:
- Check for GitHub CLI installation and authentication
- Display current protection status
- Apply branch protection rules
- Show updated protection status

### Method 3: Manual Setup via GitHub Web Interface

1. **Navigate to Settings**:
   - Go to the repository on GitHub
   - Click on **Settings** tab
   - Click on **Branches** in the left sidebar

2. **Add Branch Protection Rule**:
   - Click **Add rule** button
   - Enter `master` as the branch name pattern

3. **Configure Protection Settings**:
   ```
   ✅ Require a pull request before merging
       ✅ Require approvals (set to 1)
       ✅ Dismiss stale pull request approvals when new commits are pushed
       ✅ Require review from code owners (if CODEOWNERS file exists)
   
   ✅ Require status checks to pass before merging
       ✅ Require branches to be up to date before merging
       ☑️ Select "build-and-test" status check (if available)
   
   ✅ Require conversation resolution before merging
   
   ❌ Require signed commits (optional)
   
   ❌ Require linear history (optional)
   
   ✅ Include administrators (recommended for consistency)
   
   ✅ Restrict pushes that create files (optional)
   
   ❌ Allow force pushes (MUST be disabled)
   
   ❌ Allow deletions (MUST be disabled)
   ```

4. **Save Changes**:
   - Click **Create** to apply the protection rules

## Status Checks

The repository includes a CI workflow (`build-and-test`) that:
- Verifies the JAR file exists and is valid
- Checks documentation files are present
- Validates internal links
- Provides build summaries

This workflow provides the `build-and-test` status check required by branch protection.

## Verification

After setting up branch protection, verify it's working:

1. **Check protection status**:
   ```bash
   gh api repos/ap0ught/NMSSaveEditor/branches/master/protection
   ```

2. **Test restrictions**:
   - Try to force push to master (should fail)
   - Try to delete master branch (should fail)
   - Create a PR to master (should require review)

## Troubleshooting

### Common Issues

**Error: "Required status checks not found"**
- The CI workflow needs to run at least once to register the status check
- Push a commit to master or manually run the "Build and Test" workflow

**Error: "Insufficient permissions"**
- You need admin access to the repository to configure branch protection
- Contact the repository owner to set up protection rules

**Script fails with authentication error**
- Run `gh auth login` and authenticate with GitHub
- Ensure you have the necessary permissions

### Manual Fallback

If automated methods fail, use the GitHub web interface (Method 3) as a reliable fallback.

## Best Practices

1. **Regular Review**: Periodically review and update branch protection rules
2. **Status Checks**: Ensure CI workflows are working before requiring them
3. **Team Training**: Make sure team members understand the new workflow
4. **Documentation**: Keep this guide updated as rules evolve

## Additional Security

Consider these additional protections:

- **CODEOWNERS file**: Require specific people/teams to review certain files
- **Signed commits**: Require cryptographic signatures on commits
- **Linear history**: Prevent merge commits and require rebase
- **Restrict teams/users**: Limit who can push to protected branches

## Support

For issues with branch protection setup:
1. Check the [GitHub Actions logs](../../actions) for automated setup
2. Review this documentation
3. Contact repository maintainers
4. Refer to [GitHub's branch protection documentation](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/defining-the-mergeability-of-pull-requests/about-protected-branches)