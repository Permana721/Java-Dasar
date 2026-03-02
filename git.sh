#!/bin/bash

FILES=$(git diff --cached --name-only)
STAT=$(git diff --cached --stat)
DIFF=$(git diff --cached | head -n 400)

if [ -z "$FILES" ]; then
  echo "No staged files."
  exit 1
fi

PROMPT="You are a senior engineer.

Generate ONE conventional commit message.

Rules:
- Max 60 characters
- MUST include the main package name
- Be specific
- Only output the commit message

Changed files:
$FILES

Summary:
$STAT

Patch:
$DIFF
"

MESSAGE=$(echo "$PROMPT" | ollama run mistral 2>/dev/null)

# Jika ollama gagal
if [ $? -ne 0 ]; then
  echo "Ollama failed. Commit aborted."
  exit 1
fi

# Jika output kosong
if [ -z "$MESSAGE" ]; then
  echo "Empty commit message. Commit aborted."
  exit 1
fi

echo "Generated message:"
echo "$MESSAGE"

git commit -m "$MESSAGE"