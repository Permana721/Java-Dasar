git commit -m "$( \
FILES=$(git diff --cached --name-only); \
STAT=$(git diff --cached --stat); \
DIFF=$(git diff --cached | head -n 400); \
ollama run mistral --prompt "You are a senior engineer.

Generate ONE conventional commit message that summarizes ALL changes.
Rules:
- Max 60 characters
- Must reflect the overall change
- Do not mention individual line changes
- Only output the message

Changed files:
$FILES

Diff summary:
$STAT

Patch:
$DIFF
" )"