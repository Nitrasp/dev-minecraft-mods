package com.nitrasp.minerscavemod.regi.tab;

import com.nitrasp.minerscavemod.main.MinersCave;
import com.nitrasp.minerscavemod.regi.RegisterBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MinersCaveTabs {

    // MinersCaveのクリエイティブ用タブ
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MinersCave.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINERS_CAVE_TAB = MOD_TABS.register("minerscave_tab",
            () -> {
                return CreativeModeTab.builder()
                        .icon(() -> new ItemStack(Blocks.CHERRY_PLANKS))
                        .title(Component.translatable("itemGroup.miners_cave"))
                        .displayItems((param, output) -> {
                            for (Item item : MinersCaveItems.item) {
                                output.accept(item);
                            }
                            output.accept(RegisterBlock.CAVE_PORTAL_FRAME.get());
                        })
                        .build();
            });

    public static final RegistryObject<CreativeModeTab> MINERS_CAVE_SUB_TAB = MOD_TABS.register("minerscave_tab_sub",
            () -> {
                return CreativeModeTab.builder()
                        .icon(() -> new ItemStack(Blocks.CHERRY_PLANKS))
                        .title(Component.translatable("itemGroup.miners_cave_sub"))
                        // TODO このタブの前にくるタブを指定する。メインのタブの後に来るように設定。
                        .withTabsBefore(MinersCaveTabs.MINERS_CAVE_TAB.getId())
                        .displayItems((param, output) -> {
                            for (Item item : MinersCaveItems.item) {
                                output.accept(item);
                            }
                        })
                        .build();
            });
}
