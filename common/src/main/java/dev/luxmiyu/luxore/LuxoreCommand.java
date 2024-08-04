package dev.luxmiyu.luxore;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuxoreCommand {
    public static int execute(CommandContext<ServerCommandSource> objectCommandContext) {
        try {
            ServerCommandSource source = objectCommandContext.getSource();
            PlayerEntity player = source.getPlayer();

            if (player == null) {
                source.sendFeedback(() -> Text.translatable("message.luxore.command_not_player"), false);
                return 0;
            }

            if (!player.hasPermissionLevel(2)) {
                source.sendFeedback(() -> Text.translatable("message.luxore.command_no_permission"), false);
                return 0;
            }

            World world = player.getWorld();
            if (world == null) return 0;

            BlockPos pos = player.getBlockPos();

            ArmorStandEntity stand = new ArmorStandEntity(EntityType.ARMOR_STAND, world);
            stand.refreshPositionAndAngles(pos, 0, 0);
            stand.setShowArms(true);

            stand.equipStack(EquipmentSlot.MAINHAND, Luxore.LUXORE_SWORD.get().getDefaultStack());
            stand.equipStack(EquipmentSlot.OFFHAND, Luxore.LUXORE_PICKAXE.get().getDefaultStack());
            stand.equipStack(EquipmentSlot.HEAD, Luxore.LUXORE_HELMET.get().getDefaultStack());
            stand.equipStack(EquipmentSlot.CHEST, Luxore.LUXORE_CHESTPLATE.get().getDefaultStack());
            stand.equipStack(EquipmentSlot.LEGS, Luxore.LUXORE_LEGGINGS.get().getDefaultStack());
            stand.equipStack(EquipmentSlot.FEET, Luxore.LUXORE_BOOTS.get().getDefaultStack());

            world.spawnEntity(stand);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
