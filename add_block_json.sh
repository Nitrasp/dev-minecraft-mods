#!/bin/bash

MOD_ID="minerscavemod"

# 引数がない場合はエラーメッセージを表示して終了
if [ $# -eq 0 ]; then
    echo "引数にブロックIDを入力してください。"
    exit 1
fi

# 引数をブロックIDとして設定
BLOCK_ID="$1"

# ブロックIDが英字の小文字とアンダースコアのみで構成されているかチェック
if [[ ! "$BLOCK_ID" =~ ^[a-z_]+$ ]]; then
    echo "ブロックIDは英字の小文字とアンダースコアのみで命名してください。"
    exit 1
fi

# JSONファイルを作成するディレクトリパス
dirs=(
    "./src/main/resources/assets/$MOD_ID/models/block/"
    "./src/main/resources/assets/$MOD_ID/models/item/"
    "./src/main/resources/assets/$MOD_ID/blockstates/"
    "./src/main/resources/data/$MOD_ID/loot_tables/blocks/"
)

# ディレクトリが存在しなければ作成
for dir in "${dirs[@]}"; do
    mkdir -p "$dir"
done

# JSONファイルを作成し、コードを挿入
for dir in "${dirs[@]}"; do
    if [[ "$dir" == *"/models/block/"* ]]; then
        echo -e '{\n    "parent": "minecraft:block/cube_all",\n    "textures": {\n        "all": "'"$MOD_ID"':block/'"$BLOCK_ID"'"\n    }\n}' > "$dir$BLOCK_ID.json"
    elif [[ "$dir" == *"/models/item/"* ]]; then
        echo -e '{\n    "parent": "'"$MOD_ID"':block/'"$BLOCK_ID"'"\n}' > "$dir$BLOCK_ID.json"
    elif [[ "$dir" == *"/blockstates/"* ]]; then
        echo -e '{\n    "variants": {\n        "": {\n            "model": "'"$MOD_ID"':block/'"$BLOCK_ID"'"\n        }\n    }\n}' > "$dir$BLOCK_ID.json"
    elif [[ "$dir" == *"/loot_tables/blocks/"* ]]; then
        echo -e '{\n    "type": "minecraft:block",\n    "pools": [\n        {\n            "rolls": 1.0,\n            "bonus_rolls": 0.0,\n            "entries": [\n                {\n                    "type": "minecraft:item",\n                    "name": "'$MOD_ID':'$BLOCK_ID'"\n                }\n            ],\n            "conditions": [\n                {\n                    "condition": "minecraft:survives_explosion"\n                }\n            ]\n        }\n    ]\n}' > "$dir$BLOCK_ID.json"
    fi
done

echo "JSONファイルが作成されました。"