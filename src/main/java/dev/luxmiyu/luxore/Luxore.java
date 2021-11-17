package dev.luxmiyu.luxore;

import dev.luxmiyu.luxore.registry.BlockRegistry;
import dev.luxmiyu.luxore.registry.ItemRegistry;
import dev.luxmiyu.luxore.registry.WorldgenRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class Luxore implements ModInitializer {

    public static final ItemGroup LUXORE_GROUP = FabricItemGroupBuilder.build(ID("general"), () -> new ItemStack(ItemRegistry.get("luxore_ingot")));

    public void onInitialize() {
        BlockRegistry.init();
        ItemRegistry.init();
        WorldgenRegistry.init();
    }

    public static Identifier ID(String path) {
        return new Identifier("luxore", path);
    }

}