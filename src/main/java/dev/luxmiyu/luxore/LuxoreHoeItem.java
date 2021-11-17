package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class LuxoreHoeItem extends HoeItem {

    public LuxoreHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, FabricItemSettings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

}

