package com.nitrasp.minerscavemod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class CavePortalFrame extends Block {

    public CavePortalFrame() {
        super(Properties.of()
            .strength(1.5f, 6.0f)
            .sound(SoundType.AMETHYST)
            .lightLevel(value -> 15)
            );

    }
    
}
