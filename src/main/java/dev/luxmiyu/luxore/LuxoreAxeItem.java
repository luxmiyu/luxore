package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class LuxoreAxeItem extends AxeItem {

    public LuxoreAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, FabricItemSettings settings) {
        super(material, (float) attackDamage, attackSpeed, settings);
    }

}

