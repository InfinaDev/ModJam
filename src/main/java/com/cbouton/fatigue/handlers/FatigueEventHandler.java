package com.cbouton.fatigue.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class FatigueEventHandler {
	public NBTTagCompound nbt = new NBTTagCompound();
	private String username = "";

	@ForgeSubscribe
	public void playerSleep(PlayerSleepInBedEvent event) {
		EntityPlayer player = event.entityPlayer;
		FatigueHandler.increaseFatigue(player, 18000);
	}

	@ForgeSubscribe
	public void breakBlock(BreakEvent event){
		EntityPlayer player = event.getPlayer();
		FatigueHandler.decreaseFatigue(player, 300);
	}
	
	@ForgeSubscribe
	public void playerAttack(AttackEntityEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (!event.isCanceled()) {
			FatigueHandler.decreaseFatigue(player, 30);
		}
	}

	@ForgeSubscribe
	public void playerJoin(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			
			int amount = nbt.getInteger("FatigueAmount");
			username = player.username;
			
			FatigueHandler.initFatigue(player, amount);
		}
	}
	
	@ForgeSubscribe
	public void playerSave(WorldEvent.Save event) {
		nbt.setInteger("FatigueAmount", FatigueHandler.getFatigue(username));
	}
}
