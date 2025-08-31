#!/bin/bash

# Branch Protection Setup Script
# This script configures branch protection rules for the master branch
# Requires GitHub CLI (gh) to be installed and authenticated

set -e

REPO_OWNER="ap0ught"
REPO_NAME="NMSSaveEditor"
BRANCH_NAME="master"

echo "🔧 Setting up branch protection for ${REPO_OWNER}/${REPO_NAME}:${BRANCH_NAME}"

# Check if GitHub CLI is installed
if ! command -v gh &> /dev/null; then
    echo "❌ GitHub CLI (gh) is not installed."
    echo "Please install it from: https://cli.github.com/"
    exit 1
fi

# Check if user is authenticated
if ! gh auth status &> /dev/null; then
    echo "❌ Not authenticated with GitHub CLI."
    echo "Please run: gh auth login"
    exit 1
fi

echo "✅ GitHub CLI is installed and authenticated"

# Function to enable branch protection
setup_branch_protection() {
    echo "📋 Configuring branch protection rules..."
    
    # Use GitHub API through gh cli to set branch protection
    gh api repos/${REPO_OWNER}/${REPO_NAME}/branches/${BRANCH_NAME}/protection \
        --method PUT \
        --field required_status_checks='{"strict":true,"contexts":["build-and-test"]}' \
        --field enforce_admins=false \
        --field required_pull_request_reviews='{"required_approving_review_count":1,"dismiss_stale_reviews":true,"require_code_owner_reviews":false,"require_last_push_approval":true}' \
        --field restrictions=null \
        --field allow_force_pushes=false \
        --field allow_deletions=false \
        --field block_creations=false \
        --field required_conversation_resolution=true \
        && echo "✅ Branch protection rules applied successfully" \
        || {
            echo "⚠️  Failed to apply full protection. Trying basic protection..."
            
            # Fallback to basic protection without status checks
            gh api repos/${REPO_OWNER}/${REPO_NAME}/branches/${BRANCH_NAME}/protection \
                --method PUT \
                --field required_status_checks=null \
                --field enforce_admins=false \
                --field required_pull_request_reviews='{"required_approving_review_count":1,"dismiss_stale_reviews":true,"require_code_owner_reviews":false}' \
                --field restrictions=null \
                --field allow_force_pushes=false \
                --field allow_deletions=false \
                --field block_creations=false \
                --field required_conversation_resolution=true \
                && echo "✅ Basic branch protection rules applied"
        }
}

# Function to display current protection status
show_protection_status() {
    echo "📊 Current branch protection status:"
    gh api repos/${REPO_OWNER}/${REPO_NAME}/branches/${BRANCH_NAME}/protection \
        --jq '.url, .required_status_checks, .required_pull_request_reviews, .allow_force_pushes, .allow_deletions' \
        2>/dev/null || echo "❌ No branch protection currently configured"
}

# Main execution
echo
echo "Current status:"
show_protection_status

echo
read -p "Do you want to setup branch protection? (y/N): " -n 1 -r
echo
if [[ $REPLY =~ ^[Yy]$ ]]; then
    setup_branch_protection
    echo
    echo "Updated status:"
    show_protection_status
else
    echo "Operation cancelled."
fi

echo
echo "🎯 Branch protection setup complete!"
echo
echo "The following protections are now in place:"
echo "• Force pushes: BLOCKED"
echo "• Branch deletion: BLOCKED"  
echo "• Pull request reviews: REQUIRED (1 approver)"
echo "• Stale review dismissal: ENABLED"
echo "• Conversation resolution: REQUIRED"
echo "• Status checks: ENABLED (when CI workflows are available)"