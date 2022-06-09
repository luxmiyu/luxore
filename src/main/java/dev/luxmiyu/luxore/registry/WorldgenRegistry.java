package dev.luxmiyu.luxore.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class WorldgenRegistry {

    public static void init() {
        var LUXORE_ORE = ConfiguredFeatures.register(
            "luxore_ore", Feature.ORE,
            new OreFeatureConfig(
                List.of(
                    OreFeatureConfig.createTarget(
                        OreConfiguredFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.get("luxore_ore").getDefaultState()
                    )
                ), 8
            )
        );
        var LUXORE_ORE_UPPER = PlacedFeatures.register(
            "luxore_ore_upper", LUXORE_ORE,
            modifiersWithCount(
                80,
                HeightRangePlacementModifier.trapezoid(
                    YOffset.fixed(60),
                    YOffset.fixed(324)
                )
            )
        );
        var LUXORE_ORE_LOWER = PlacedFeatures.register(
            "luxore_ore_lower", LUXORE_ORE,
            modifiersWithCount(
                10,
                HeightRangePlacementModifier.trapezoid(
                    YOffset.fixed(-14),
                    YOffset.fixed(44)
                )
            )
        );
        LUXORE_ORE_UPPER.getKey().ifPresent(ore -> BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ore));
        LUXORE_ORE_LOWER.getKey().ifPresent(ore -> BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ore));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
