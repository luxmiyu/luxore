package dev.luxmiyu.luxore.fabric.client;

import dev.luxmiyu.luxore.Luxore;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public final class LuxoreFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Luxore.LUXORE_GLASS.get(), RenderLayer.getCutout());
    }
}
