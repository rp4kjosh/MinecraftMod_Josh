package com.josh.rp4kmod.util;

import com.josh.rp4kmod.RP4KMod;
import com.josh.rp4kmod.blocks.BlockItemBase;
import com.josh.rp4kmod.blocks.BouncyBlock;
import com.josh.rp4kmod.blocks.TitaniumOreBlock;
import com.josh.rp4kmod.entities.BombEntity;
import com.josh.rp4kmod.entities.PenguinEggEntity;
import com.josh.rp4kmod.entities.PenguinEntity;
import com.josh.rp4kmod.items.*;
import com.josh.rp4kmod.world.biomes.BouncyBiome;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.Block;

public class RegistryHandler {

    // Deffered Registers
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RP4KMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RP4KMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, RP4KMod.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, RP4KMod.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", TitaniumPickaxe::new);
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", TitaniumAxe::new);
    public static final RegistryObject<Item> TITANIUM_SPADE = ITEMS.register("titanium_spade", TitaniumShovel::new);
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", TitaniumSword::new);
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", TitaniumHoe::new);
    public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", ItemBase::new);
    public static final RegistryObject<Item> BOMB = ITEMS.register("bomb", Bomb::new);
    public static final RegistryObject<Item> WAND = ITEMS.register("wand", Wand::new);
    public static final RegistryObject<Item> PENGUIN_EGG = ITEMS.register("penguin_egg", PenguinEgg::new);


    // Blocks
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);
    public static final RegistryObject<Block> BOUNCY_BLOCK = BLOCKS.register("bouncy_block", BouncyBlock::new);

    // Block Items
    public static final RegistryObject<Item> TITANIUM_BLOCK_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));
    public static final RegistryObject<Item> BOUNCY_BLOCK_ITEM = ITEMS.register("bouncy_block", () -> new BlockItemBase(BOUNCY_BLOCK.get()));


    //Armor Items
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", TitaniumHelmet::new);
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", TitaniumChestplate::new);
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", TitaniumLeggings::new);
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", TitaniumBoots::new);

    //Entities
    public static final RegistryObject<EntityType<BombEntity>> BOMB_ENTITY = ENTITIES
            .register("bomb",
                    () -> EntityType.Builder.<BombEntity>create(BombEntity::new, EntityClassification.MISC)
                            .size(0.5f, 0.5f)
                            .build("bomb")
            );

    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN_ENTITY = ENTITIES
            .register("penguin",
                    () -> EntityType.Builder.<PenguinEntity>create(PenguinEntity::new, EntityClassification.CREATURE)
                            .size(1f, 1f)
                            .build("penguin")
            );

    public static final RegistryObject<EntityType<PenguinEggEntity>> PENGUIN_EGG_ENTITY = ENTITIES
            .register("penguin_egg",
                    () -> EntityType.Builder.<PenguinEggEntity>create(PenguinEggEntity::new, EntityClassification.MISC)
                            .size(0.5f, 0.5f)
                            .build("penguin_egg")
            );

    //Biomes
    public static final RegistryObject<Biome> BOUNCY_BIOME = BIOMES.register("bouncy_biome", BouncyBiome::new);

    public static void registerBiomes(){
        registerBiome(BOUNCY_BIOME.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.MAGICAL);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types){
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
