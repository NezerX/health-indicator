package com.nezerx.healthindicator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(HealthIndicatorMod.MODID)
public class HealthIndicatorMod {
    public static final String MODID = "healthindicator";

    public HealthIndicatorMod() {
        MinecraftForge.EVENT_BUS.register(new HealthRenderEventHandler());
    }
}