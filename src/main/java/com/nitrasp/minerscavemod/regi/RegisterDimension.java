package com.nitrasp.minerscavemod.regi;

import com.nitrasp.minerscavemod.main.MinersCave;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;

public class RegisterDimension {
	public static final ResourceKey<Level> miners_cave_world = ResourceKey.create(Registries.DIMENSION,
			new ResourceLocation(MinersCave.MOD_ID, "miners_cave_world"));
	public static final ResourceKey<LevelStem> miners_cave_world_stem = ResourceKey.create(Registries.LEVEL_STEM,
			new ResourceLocation(MinersCave.MOD_ID, "miners_cave_world"));

	public static void register() {
		System.out.println("Registering ModDimensions for " + MinersCave.MOD_ID);
	}
}
