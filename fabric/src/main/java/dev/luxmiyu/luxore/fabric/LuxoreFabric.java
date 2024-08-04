package dev.luxmiyu.luxore.fabric;

import net.fabricmc.api.ModInitializer;

import dev.luxmiyu.luxore.Luxore;

public final class LuxoreFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Luxore.init();
    }
}
