package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class LuxoreOreBlock extends Block {

    public LuxoreOreBlock() {
        super(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
    }

}

