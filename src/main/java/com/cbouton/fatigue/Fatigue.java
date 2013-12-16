package com.cbouton.fatigue;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;

import com.cbouton.fatigue.gui.FatigueBarGui;
import com.cbouton.fatigue.handlers.FatigueEventHandler;
import com.cbouton.fatigue.handlers.FatigueHandler;
import com.cbouton.fatigue.handlers.FatiguePacketHandler;
import com.cbouton.fatigue.handlers.FatigueTickHandler;
import com.cbouton.fatigue.lib.Config;
import com.cbouton.fatigue.lib.ModItems;
import com.cbouton.fatigue.lib.Statics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Statics.MODID, version = Statics.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = Statics.CHANNEL, packetHandler = FatiguePacketHandler.class)
public class Fatigue {
	public int difficulty = 1;
	public static HashMap<String, Integer> fatigue = new HashMap<String, Integer>();

	// TODO: Init blocks

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModItems.init();

		// TODO: Register Movement, Player Sleep and Item Use Events.
		MinecraftForge.EVENT_BUS.register(new FatigueEventHandler());
		System.out.println(Statics.MODID + " Version " + Statics.VERSION
				+ " Loaded");
		
		if (Minecraft.getMinecraft().isSingleplayer()){
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			FatigueHandler.initFatigue(player, 0);
			NBTTagCompound nbt = new NBTTagCompound();
			int amount = nbt.getInteger(player.toString());
			FatigueHandler.initFatigue(player, amount);
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new FatigueBarGui(Minecraft
				.getMinecraft()));

		TickRegistry.registerTickHandler(new FatigueTickHandler(), Side.CLIENT);
	}
	@EventHandler
	public void serverStart(FMLServerStartingEvent event){
		event.registerServerCommand(new FatigueCommand());
	}
}
/*
 * TODO Automatic regen on peaceful
 * 
 * 10 steps/1 mining Operation is the same decrease
 * 
 * above 50% hunger decreases slower/below 50% hunger decreases faster Hard has
 * players spawn at 50% fatigue
 * 
 * Sleeping is the best way to increase fatigue Mounted for a full day increases
 * fatigue by 1/3 of sleeping if not moving. if moving, fatigue decreases at 50%
 * the difficulty rate
 */