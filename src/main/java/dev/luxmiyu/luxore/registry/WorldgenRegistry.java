package dev.luxmiyu.luxore.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import static dev.luxmiyu.luxore.Luxore.ID;

public class WorldgenRegistry {

    public static ConfiguredFeature<?, ?> LUXORE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BlockRegistry.get("luxore_ore").getDefaultState(), 7))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 64)))
            .spreadHorizontally()
            .repeat(14);

    public static void init() {
        RegistryKey<ConfiguredFeature<?, ?>> luxoreOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, ID("luxore_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, ID("luxore_ore_overworld"), LUXORE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, luxoreOreOverworld);
    }

}
