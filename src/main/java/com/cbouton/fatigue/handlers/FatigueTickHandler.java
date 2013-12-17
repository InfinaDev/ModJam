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

	@SuppressWarnings("unused")
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		FatiguePacketHandler handler = new FatiguePacketHandler();
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;

		if (player != null) {
			if (FatigueHandler.getFatigue(player.username) <= 3000
					&& !player.capabilities.isCreativeMode) {
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown
						.getId(), 2, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown
						.getId(), 2, 2));
			} else if (FatigueHandler.getFatigue(player.username) >= 54000
					&& !player.capabilities.isCreativeMode) {
				player.addPotionEffect(new PotionEffect(
						Potion.digSpeed.getId(), 2, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed
						.getId(), 2, 2));
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
