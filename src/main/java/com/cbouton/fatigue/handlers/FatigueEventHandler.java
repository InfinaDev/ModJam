package com.cbouton.fatigue.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class FatigueEventHandler {
	public NBTTagCompound nbt = new NBTTagCompound();
	private String username = "";

	@SubscribeEvent
	public void playerSleep(PlayerSleepInBedEvent event) {
		EntityPlayer player = event.entityPlayer;
		FatigueHandler.increaseFatigue(player, 18000);
	}

	@SubscribeEvent
	public void breakBlock(BreakEvent event){
		EntityPlayer player = event.getPlayer();
		FatigueHandler.decreaseFatigue(player, 30);
	}
	
	@SubscribeEvent
	public void playerAttack(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (!event.isCanceled()) {
			FatigueHandler.decreaseFatigue(player, 30);
		}
	}

	@SubscribeEvent
	public void playerJoin(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			
			int amount = nbt.getInteger("FatigueAmount");
			username = player.getDisplayName();
			
			FatigueHandler.initFatigue(player, amount);
		}
	}
	
	@SubscribeEvent
	public void playerSave(WorldEvent.Save event) {
		nbt.setInteger("FatigueAmount", FatigueHandler.getFatigue(username));
	}
}
