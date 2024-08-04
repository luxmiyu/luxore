package dev.luxmiyu.luxore;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class Luxore {
    public static final String MOD_ID = "luxore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM_GROUP);
    public static final RegistrySupplier<ItemGroup> LUXORE_TAB = TABS.getRegistrar().register(
        Identifier.of(MOD_ID, "luxore_tab"),
        () -> CreativeTabRegistry.create(
            Text.translatable("luxore.display_name"),
            () -> new ItemStack(Registries.ITEM.get(Identifier.of(MOD_ID, "luxore_dust")))
        )
    );

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(MOD_ID, RegistryKeys.ARMOR_MATERIAL);

    private static Item.Settings tabbed() {
        return new Item.Settings().arch$tab(LUXORE_TAB);
    }

    private static Item.Settings single() {
        return tabbed().maxCount(1);
    }

    private static Item.Settings tool(ToolMaterial material, float baseAttackDamage, float attackSpeed) {
        return single().attributeModifiers(PickaxeItem.createAttributeModifiers(material, baseAttackDamage, attackSpeed));
    }

    private static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        RegistrySupplier<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), tabbed()));
        return block;
    }

    public static final RegistrySupplier<ArmorMaterial> armorSupplier = ARMOR_MATERIALS.register("luxore", LuxoreMaterial::armor);

    public static final RegistrySupplier<Item> LUXORE_SWORD = ITEMS.register("luxore_sword", () -> new SwordItem(LuxoreMaterial.tool(), tool(LuxoreMaterial.tool(), 3f, -2.4f)));
    public static final RegistrySupplier<Item> LUXORE_PICKAXE = ITEMS.register("luxore_pickaxe", () -> new PickaxeItem(LuxoreMaterial.tool(), tool(LuxoreMaterial.tool(), 1f, -2.8f)));
    public static final RegistrySupplier<Item> LUXORE_AXE = ITEMS.register("luxore_axe", () -> new AxeItem(LuxoreMaterial.tool(), tool(LuxoreMaterial.tool(), 5f, -3f)));
    public static final RegistrySupplier<Item> LUXORE_SHOVEL = ITEMS.register("luxore_shovel", () -> new ShovelItem(LuxoreMaterial.tool(), tool(LuxoreMaterial.tool(), 3f, -2.4f)));
    public static final RegistrySupplier<Item> LUXORE_HOE = ITEMS.register("luxore_hoe", () -> new HoeItem(LuxoreMaterial.tool(), tool(LuxoreMaterial.tool(), -3f, -0f)));

    public static final RegistrySupplier<Item> LUXORE_HELMET = ITEMS.register("luxore_helmet", () -> new ArmorItem(armorSupplier, ArmorItem.Type.HELMET, single().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(24))));
    public static final RegistrySupplier<Item> LUXORE_CHESTPLATE = ITEMS.register("luxore_chestplate", () -> new ArmorItem(armorSupplier, ArmorItem.Type.CHESTPLATE, single().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(24))));
    public static final RegistrySupplier<Item> LUXORE_LEGGINGS = ITEMS.register("luxore_leggings", () -> new ArmorItem(armorSupplier, ArmorItem.Type.LEGGINGS, single().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(24))));
    public static final RegistrySupplier<Item> LUXORE_BOOTS = ITEMS.register("luxore_boots", () -> new ArmorItem(armorSupplier, ArmorItem.Type.BOOTS, single().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(24))));

    public static final RegistrySupplier<Item> LUXORE_DUST = ITEMS.register("luxore_dust", () -> new Item(tabbed()));
    public static final RegistrySupplier<Item> LUXORE_INGOT = ITEMS.register("luxore_ingot", () -> new Item(tabbed()));

    public static final RegistrySupplier<Block> LUXORE_GLASS = registerBlock("luxore_glass", () -> new TransparentBlock(AbstractBlock.Settings.copy(Blocks.GLASS)));
    public static final RegistrySupplier<Block> LUXORE_BLOCK = registerBlock("luxore_block", () -> new LuxoreBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final RegistrySupplier<Block> LUXORE_SAND = registerBlock("luxore_sand", () -> new ColoredFallingBlock(new ColorCode(0xff99be), AbstractBlock.Settings.copy(Blocks.SAND)));
    public static final RegistrySupplier<Block> LUXORE_LAMP = registerBlock("luxore_lamp", () -> new Block(AbstractBlock.Settings.copy(Blocks.GLASS).luminance((state) -> 15)));
    public static final RegistrySupplier<Block> LUXORE_STONE = registerBlock("luxore_stone", () -> new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final RegistrySupplier<Block> LUXORE_ORE = registerBlock("luxore_ore", () -> new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static void init() {
        ARMOR_MATERIALS.register();
        BLOCKS.register();
        ITEMS.register();

        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
            dispatcher.register(LiteralArgumentBuilder.<ServerCommandSource>literal("luxore").executes(LuxoreCommand::execute));
        });

        LOGGER.info("Initialized!");
    }
}
