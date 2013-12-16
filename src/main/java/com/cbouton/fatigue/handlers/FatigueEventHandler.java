package com.cbouton.fatigue.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class FatigueEventHandler {
	public FatigueHandler handler = new FatigueHandler();
	public NBTTagCompound nbt = new NBTTagCompound();

	@ForgeSubscribe
	public void playerSleep(PlayerSleepInBedEvent event) {
		EntityPlayer player = event.entityPlayer;
		handler.increaseFatigue(player, 18000);
	}

	@ForgeSubscribe
	public void playerSleep(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (!event.isCanceled()) {
			handler.decreaseFatigue(player, 3);
		}
	}
	@ForgeSubscribe
	public void playerJoin(EntityJoinWorldEvent event){
		if (event.entity instanceof EntityPlayer){
		EntityPlayer player = (EntityPlayer) event.entity;
		int amount = nbt.getInteger(player.toString());
			handler.initFatigue(player, amount);
		}
	}
}
