package com.cbouton.fatigue.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class playerEvent {
	
	@ForgeSubscribe
	public void playerSleep(PlayerSleepInBedEvent event){
		EntityPlayer player = event.entityPlayer;
	}
	@ForgeSubscribe
	public void playerSleep(AttackEntityEvent event){
		EntityPlayer player = event.entityPlayer;
	}


}
