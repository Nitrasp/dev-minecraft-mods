package com.nitrasp.minerscavemod.main;

import com.nitrasp.minerscavemod.regi.RegisterBlock;
import com.nitrasp.minerscavemod.regi.RegisterDimension;
import com.nitrasp.minerscavemod.regi.RegisterItems;
import com.nitrasp.minerscavemod.regi.tab.MinersCaveTabs;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinersCave.MOD_ID)
public class MinersCave {

    public static final String MOD_ID = "minerscavemod";

    public MinersCave() {
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RegisterItems.ITEMS.register(bus);
        RegisterBlock.BLOCKS.register(bus);
        MinersCaveTabs.MOD_TABS.register(bus);
        RegisterDimension.register();
    }

}
