package dev.luxmiyu.luxore;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class LuxoreMaterial implements ToolMaterial {
    private LuxoreMaterial() {
    }

    public int getDurability() {
        return 420;
    }

    public float getMiningSpeedMultiplier() {
        return 8f;
    }

    public float getAttackDamage() {
        return 4f;
    }

    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    public int getEnchantability() {
        return 20;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Luxore.LUXORE_INGOT.get());
    }

    static public LuxoreMaterial tool() {
        return new LuxoreMaterial();
    }

    static public ArmorMaterial armor() {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);

        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 5);

        int enchantibility = 20;
        RegistryEntry<SoundEvent> sound = SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
        Supplier<Ingredient> repairIngredient = Suppliers.memoize(() -> Ingredient.ofItems(Luxore.LUXORE_INGOT.get()));
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(Luxore.MOD_ID, "luxore")));
        float toughness = 0f;
        float knockbackResistance = 0f;


        return new ArmorMaterial(enumMap, enchantibility, sound, repairIngredient, list, toughness, knockbackResistance);
    }
}
