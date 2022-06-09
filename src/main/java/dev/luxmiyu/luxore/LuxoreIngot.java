package dev.luxmiyu.luxore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LuxoreIngot extends Item {

    public LuxoreIngot(ItemGroup group) {
        super(new FabricItemSettings().group(group));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient) {
            playerEntity.sendMessage(Text.translatable("luxore.ingot.on_use", playerEntity.getEntityName()), false);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

}