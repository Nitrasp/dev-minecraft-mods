package com.nitrasp.minerscavemod.regi;

import com.nitrasp.minerscavemod.item.MinersStone;
import com.nitrasp.minerscavemod.main.MinersCave;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinersCave.MOD_ID);

    public static final RegistryObject<Item> MINERS_STONE = ITEMS.register("miners_stone", MinersStone::new);

}
