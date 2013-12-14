package com.cbouton.fatigue;

import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.events.playerEvent;
import com.cbouton.fatigue.lib.Config;
import com.cbouton.fatigue.lib.ModItems;
import com.cbouton.fatigue.lib.Statics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Statics.MODID, version = Statics.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = Statics.CHANNEL, packetHandler=PacketHandler.class)
public class Fatigue {
	public int difficulty = 1;

	// TODO: Init blocks

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModItems.init();
		// TODO: Register Movement, Player Sleep and Item Use Events.
		MinecraftForge.EVENT_BUS.register(new playerEvent());
		System.out.println(Statics.MODID + " Version " + Statics.VERSION
				+ " Loaded");
	}
}
/*
 * Automatic regen on peaceful Easy increases at double and decreases by half
 * Normal increases and decreases by the default amounts Hard increases at half
 * and decrease by double
 * 
 * 1/2 fatigue is normal full fatigue gives Haste/Speed no fatigue gives
 * Slowness/Mining Fatigue
 * 
 * 10 steps/1 mining Operation is the same decrease
 * 
 * above 50% hunger decreases slower/below 50% hunger decreases faster Hard has
 * players spawn at 50% fatigue
 * 
 * Sleeping is the best way to increase fatigue Mounted for a full day increases
 * fatigue by 1/4 of sleeping if not moving. if moving, fatigue decreases at 50%
 * the difficulty rate
 * 
 * Values can be determined later.
 */