package dev.luxmiyu.luxore.registry;

import dev.luxmiyu.luxore.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

import static dev.luxmiyu.luxore.Luxore.LUXORE_GROUP;

public final class ItemRegistry {

    private ItemRegistry() {}

    private static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void init() {
        if (!ITEMS.isEmpty()) {
            return;
        }
        createAndRegister("luxore_ingot", new LuxoreIngot(LUXORE_GROUP));
        createAndRegister("luxore_ore", new BlockItem(BlockRegistry.get("luxore_ore"), new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_block", new BlockItem(BlockRegistry.get("luxore_block"), new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_sword", new SwordItem(LuxoreToolMaterial.INSTANCE, 2, -2.4f, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_pickaxe", new LuxorePickaxeItem(LuxoreToolMaterial.INSTANCE, 1, -2.4f, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_axe", new LuxoreAxeItem(LuxoreToolMaterial.INSTANCE, 3, -2.4f, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_shovel", new ShovelItem(LuxoreToolMaterial.INSTANCE, 1.0f, -2.4f, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_hoe", new LuxoreHoeItem(LuxoreToolMaterial.INSTANCE, 1, -2.4f, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_helmet", new ArmorItem(LuxoreArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_chestplate", new ArmorItem(LuxoreArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_leggings", new ArmorItem(LuxoreArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new FabricItemSettings().group(LUXORE_GROUP)));
        createAndRegister("luxore_boots", new ArmorItem(LuxoreArmorMaterial.INSTANCE, EquipmentSlot.FEET, new FabricItemSettings().group(LUXORE_GROUP)));
    }

    private static void createAndRegister(String id, Item item) {
        ITEMS.put(id, Registry.register(Registry.ITEM, Luxore.ID(id), item));
    }

    public static Item get(String item) {
        return ITEMS.getOrDefault(item, Items.AIR);
    }

}
