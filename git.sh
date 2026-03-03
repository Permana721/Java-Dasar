#!/usr/bin/env bash

MODEL="tinyllama:latest"   # Model quantized untuk CPU
MAX_DIFF_LINES=50

function get_changed_files() {
    git status --porcelain | awk '{print $2}'
}

function generate_commit_message() {
    local file="$1"

    diff_content=$(git diff "$file" | head -n $MAX_DIFF_LINES)

    prompt="Generate ONE git commit message.
Format strictly:
type(scope): short summary
Allowed types: feat, fix, refactor, chore, docs, style, test, perf.
Max 72 characters.
No explanation.

Diff:
$diff_content"

    raw_output=$(ollama run "$MODEL" <<< "$prompt")

    # Ambil baris pertama saja
    commit_msg=$(echo "$raw_output" | head -n 1 | tr -d '"' | tr -d '`')

    # Validasi Conventional Commit format
    if [[ ! $commit_msg =~ ^(feat|fix|refactor|chore|docs|style|test|perf)\(.*\):\ .* ]]; then
        commit_msg="chore($file): update $file"
    fi

    echo "$commit_msg"
}

while true; do
    mapfile -t files < <(get_changed_files)

    if [ ${#files[@]} -eq 0 ]; then
        echo "Tidak ada file yang berubah."
        exit 0
    fi

    echo "==== Pilih file yang ingin di-commit ===="
    for i in "${!files[@]}"; do
        echo "$((i+1)). ${files[$i]}"
    done
    echo "0. Keluar"
    echo "=========================================="

    read -p "Masukkan nomor: " choice

    if [ "$choice" -eq 0 ]; then
        exit 0
    fi

    if [ "$choice" -gt 0 ] && [ "$choice" -le "${#files[@]}" ]; then
        selected_file="${files[$((choice-1))]}"

        echo "Generating commit message untuk $selected_file..."
        commit_msg=$(generate_commit_message "$selected_file" | head -n 1 | tr -d '"' | tr -d '`')

        echo "----------------------------------"
        echo "Suggested Commit Message:"
        echo "$commit_msg"
        echo "----------------------------------"

        read -p "Gunakan commit ini? (y/n): " confirm
        if [[ "$confirm" == "y" ]]; then
            git add "$selected_file"
            git commit -m "$commit_msg"
            echo "Commit berhasil."
        fi
    else
        echo "Pilihan tidak valid."
    fi

    echo ""
done