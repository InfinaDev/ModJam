package com.cbouton.fatigue.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.EnumSet;

public class FatigueTickHandler{

	@SubscribeEvent
	public void tickStart(TickEvent.ServerTickEvent event) {
		String[] players = Minecraft.getMinecraft().getIntegratedServer().getAllUsernames();

        for (int i=0; i<players.length; i++){
		    EntityPlayer player = Minecraft.getMinecraft().getIntegratedServer().getConfigurationManager().getPlayerForUsername(players[i]);
		    if (player != null) {
			    if (FatigueHandler.getFatigue(players[i]) < 3000
					    && !player.capabilities.isCreativeMode) {
				    player.addPotionEffect(new PotionEffect(Potion.digSlowdown
						    .getId(), 20, 2));
				    player.addPotionEffect(new PotionEffect(Potion.moveSlowdown
						.   getId(), 20, 2));
				    player.removePotionEffect(Potion.moveSpeed.getId());
				    player.removePotionEffect(Potion.digSpeed.getId());
			    } else if (FatigueHandler.getFatigue(players[i]) > 54000
					    && !player.capabilities.isCreativeMode) {
				    player.addPotionEffect(new PotionEffect(
						    Potion.digSpeed.getId(), 20, 1));
				    player.addPotionEffect(new PotionEffect(Potion.moveSpeed
						    .getId(), 20, 1));
				    player.removePotionEffect(Potion.moveSlowdown.getId());
				    player.removePotionEffect(Potion.digSlowdown.getId());
			    } else {
				    player.removePotionEffect(Potion.moveSpeed.getId());
				    player.removePotionEffect(Potion.digSpeed.getId());
				    player.removePotionEffect(Potion.moveSlowdown.getId());
				    player.removePotionEffect(Potion.digSlowdown.getId());
			    }

		    }
        }
	}

}