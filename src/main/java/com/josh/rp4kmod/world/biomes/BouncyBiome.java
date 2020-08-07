package com.josh.rp4kmod.world.biomes;

import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class BouncyBiome extends Biome {

    public BouncyBiome() {
        super(new Biome.Builder().parent(null)
                .precipitation(RainType.NONE)
                .downfall(0.5f)
                .depth(0.5f)
                .category(Category.PLAINS)
                .scale(1.2f)
                .temperature(0.5f)
                .waterColor(0xc90579)
                .waterFogColor(0xc90579)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(RegistryHandler.BOUNCY_BLOCK.get().getDefaultState(),
                                Blocks.DIRT.getDefaultState(),
                                Blocks.OBSIDIAN.getDefaultState()))
        );
        //addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig((0.05f))));
    }
}
