package com.cbouton.fatigue.events;

import com.cbouton.fatigue.FatigueHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class playerEvent {
	public FatigueHandler handler = new FatigueHandler();
	public NBTTagCompound nbt = new NBTTagCompound();

	@ForgeSubscribe
	public void playerSleep(PlayerSleepInBedEvent event) {
		EntityPlayer player = event.entityPlayer;
		handler.increaseFatigue(player, 2000);
	}

	@ForgeSubscribe
	public void playerSleep(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (!event.isCanceled()) {
			handler.decreaseFatigue(player, 3);
		}
	}
	@ForgeSubscribe
	public void playerLeave(EntityJoinWorldEvent event){
		if (event.entity instanceof EntityPlayer){
		EntityPlayer player = (EntityPlayer) event.entity;
		int amount = nbt.getInteger(player.toString());
			handler.initFatigue(player, amount);
		}
	}
}
