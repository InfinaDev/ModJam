package com.cbouton.fatigue;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.cbouton.fatigue.events.playerEvent;
import com.cbouton.fatigue.lib.Statics;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Statics.MODID, version = Statics.VERSION)
public class Fatigue
{
	public int difficulty;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		//TODO: Register Movement, Player Sleep and Item Use Events.
    	MinecraftForge.EVENT_BUS.register(new playerEvent());
    	//TODO: Get game mode updates
    	difficulty = Minecraft.getMinecraft().theWorld.difficultySetting;
        System.out.println(Statics.MODID + " Version " + Statics.VERSION + " Loaded");
    }
}
