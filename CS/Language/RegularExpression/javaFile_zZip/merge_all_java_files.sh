#!/bin/bash
save_file="java-files-$(date '+%Y%M%D%H%M%S').Z"
find ./U3 -name '*.java' | while read -a file; do
    charset=$(file -i "$file" | sed -E 's/.*; charset=(.*)$/\1/')
    echo "$file, $charset"
    if [ "$charset" != "utf-8" ]; then
        grep -Han . "$file" | iconv -f cp 949 -t utf-8 | gzip >> "$save_file"
    else 
        grep -Han . "$file" | gzip >> "$save_file"
    fi
done
f.whire-( ";$$ cc")