package com.nitrasp.minerscavemod.regi.tab;

import com.nitrasp.minerscavemod.regi.RegisterBlock;
import com.nitrasp.minerscavemod.regi.RegisterItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

public class MinersCaveItems {

    public static final ItemLike [] itemList = {
        Items.DIRT,
        Items.COBBLESTONE,
        RegisterItems.MINERS_STONE.get(),
        RegisterBlock.CAVE_PORTAL_FRAME.get(),
        RegisterBlock.CAVE_PORTAL_EDGE.get()
    };
    
}
