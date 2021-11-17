package dev.luxmiyu.luxore.registry;

import dev.luxmiyu.luxore.Luxore;
import dev.luxmiyu.luxore.LuxoreBlock;
import dev.luxmiyu.luxore.LuxoreOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public final class BlockRegistry {

    private BlockRegistry() {}

    private static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void init() {
        if (!BLOCKS.isEmpty()) {
            return;
        }
        createAndRegister("luxore_ore", new LuxoreOreBlock());
        createAndRegister("luxore_block", new LuxoreBlock());
    }

    private static void createAndRegister(String id, Block block) {
        BLOCKS.put(id, Registry.register(Registry.BLOCK, Luxore.ID(id), block));
    }

    public static Block get(String block) {
        return BLOCKS.getOrDefault(block, Blocks.AIR);
    }

}
