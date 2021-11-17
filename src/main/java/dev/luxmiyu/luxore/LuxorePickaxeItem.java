package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class LuxorePickaxeItem extends PickaxeItem {

    public LuxorePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, FabricItemSettings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

}

