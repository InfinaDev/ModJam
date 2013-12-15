package com.cbouton.fatigue.handlers;

import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class FatigueHandler {
	public HashMap<EntityPlayer, Short> fatigue = new HashMap<EntityPlayer, Short>();

	public void decreaseFatigue(EntityPlayer player, int amount) {
		// TODO: Decrease players Fatigue by amount;
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 3) {
			amount = amount * 2;
		} else if (difficulty == 1) {
			amount = (int) (amount * 0.5);
		}
		fatigue.remove(player);
		fatigue.put(player, (short) amount);
	}

	public void increaseFatigue(EntityPlayer player, int amount) {
		// TODO: Increase players Fatigue by amount;
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 1) {
			amount = amount * 2;
		} else if (difficulty == 3) {
			amount = (int) (amount * 0.5);
		}
		fatigue.remove(player);
		fatigue.put(player, (short) amount);
	}

	public int getFatigue(EntityPlayer player) {
		// TODO: get Fatigue amount by player;
		int amount = fatigue.get(player);
		return amount;
	}

	public void initFatigue(EntityPlayer player, int amount) {
		// TODO set player fatigue upon join
		int difficulty = player.getEntityWorld().difficultySetting;
		if ((Integer) amount == null) {
			if (difficulty == 3) {
				amount = 30000;
				fatigue.put(player, (short) amount);
			} else {
				amount = 60000;
				fatigue.put(player, (short) amount);
			}
		} else {
			fatigue.put(player, (short) amount);
		}

	}

}
