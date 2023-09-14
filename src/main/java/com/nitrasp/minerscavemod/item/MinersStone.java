package com.nitrasp.minerscavemod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class MinersStone extends Item {

    public MinersStone(){
        super(new Properties()
            // 炎で燃えない
            .fireResistant()
            // レアリティ（色）
            .rarity(Rarity.RARE)
            // 耐久値
            // .durability(1)
            // スタック数(耐久値とは競合してクラッシュするためコメントアウト)
            .stacksTo(75)
        );
    }

}