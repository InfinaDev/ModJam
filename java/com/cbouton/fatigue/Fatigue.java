package com.cbouton.fatigue;

import com.cbouton.fatigue.lib.Statics;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Statics.MODID, version = Statics.VERSION)
public class Fatigue
{
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println(Statics.MODID + " Version " + Statics.VERSION + " Loaded");
    }
}
