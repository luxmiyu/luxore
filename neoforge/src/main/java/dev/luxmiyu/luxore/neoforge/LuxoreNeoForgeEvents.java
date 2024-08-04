package dev.luxmiyu.luxore.neoforge;

import dev.luxmiyu.luxore.Luxore;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Luxore.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LuxoreNeoForgeEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        // This will run the operation on the main thread, ensuring thread safety.
        event.enqueueWork(() -> {
            RenderLayers.setRenderLayer(Luxore.LUXORE_GLASS.get(), RenderLayer.getCutout());
        });
    }
}