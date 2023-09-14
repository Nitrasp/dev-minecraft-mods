package com.nitrasp.minerscavemod.regi;

import java.util.function.Supplier;

import com.nitrasp.minerscavemod.block.CavePortalFrame;
import com.nitrasp.minerscavemod.main.MinersCave;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegisterBlock {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            MinersCave.MOD_ID);

    /** Caveポータルフレーム */
    public static final RegistryObject<Block> CAVE_PORTAL_FRAME = registerBlock("cave_portal_frame",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.STONE)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()));

    /** Caveポータルエッジ */
    public static final RegistryObject<Block> CAVE_PORTAL_EDGE = registerBlock("cave_portal_edge",
            () -> new CavePortalFrame());

    /**
     * <p>
     * ブロックの登録メソッド
     * </p>
     * <p>
     * アイテムプロパティは初期値に固定されます
     * </p>
     * 
     * @param <T>   Block型のサブクラス
     * @param name  ブロックID
     * @param block Block型のインスタンス
     * @return RegistryObject<T>
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, new Item.Properties());
    }

    /**
     * <p>
     * ブロックの登録メソッド
     * </p>
     * <p>
     * アイテムプロパティを引数で指定します
     * </p>
     * 
     * @param <T>   Block型のサブクラス
     * @param name  ブロックID
     * @param block Block型のインスタンス
     * @return RegistryObject<T>
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
            Item.Properties properties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, properties);
        return toReturn;
    }

    /**
     * <p>
     * ブロックアイテムの登録メソッド
     * </p>
     * <p>
     * ブロックをアイテムプロパティに則って登録します
     * </p>
     * 
     * @param <T>        Block型のサブクラス
     * @param name       ブロックID
     * @param block      Block型のインスタンス
     * @param properties アイテムプロパティのインスタンス
     * @return I extends T
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
            Item.Properties properties) {
        return RegisterItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
