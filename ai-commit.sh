#!/bin/bash

DIFF=$(git diff --cached)

if [ -z "$DIFF" ]; then
  echo "chore: empty commit"
  exit 0
fi

PROMPT="
You are a senior software engineer.

Write a semantic git commit message.

Rules:
- Allowed types: chore, docs, feat, fix, refactor, style, test
- Format: <type>(<scope>): <present tense summary>
- Summary must be concise and technical
- Max 72 characters in title
- Optional body allowed
- Only output the commit message
- Do not add explanations

Git diff:
$DIFF
"

echo "$PROMPT" | ollama run mistral
