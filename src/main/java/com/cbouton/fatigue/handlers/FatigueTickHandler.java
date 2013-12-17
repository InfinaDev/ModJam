package com.cbouton.fatigue.handlers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class FatigueTickHandler implements ITickHandler {

	@Override
	public String getLabel() {
		return "FatigueTickHandler";
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		if (player != null) {
			if (FatigueHandler.getFatigue(player.username) < 3000
					&& !player.capabilities.isCreativeMode) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown
						.getId(), 600, 3));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown
						.getId(), 600, 3));
			} else if (FatigueHandler.getFatigue(player.username) > 54000
					&& !player.capabilities.isCreativeMode) {
				player.addPotionEffect(new PotionEffect(
						Potion.digSpeed.getId(), 600, 3));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), 600, 3));
			} else {
				player.removePotionEffect(Potion.moveSpeed.getId());
				player.removePotionEffect(Potion.digSpeed.getId());
				player.removePotionEffect(Potion.moveSlowdown.getId());
				player.removePotionEffect(Potion.digSlowdown.getId());
			}

		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
