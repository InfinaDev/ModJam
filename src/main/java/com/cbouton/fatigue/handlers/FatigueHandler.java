package com.cbouton.fatigue.handlers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import com.cbouton.fatigue.Fatigue;
import com.cbouton.fatigue.lib.Statics;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.FMLCommonHandler;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FatigueHandler {

	@SuppressWarnings("unused")
	public void sendPacket(EntityPlayer player, int amount) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(4);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeInt(amount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = Statics.CHANNEL;
		packet.data = bos.toByteArray();
		packet.length = bos.size();

		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			EntityPlayerMP playerEntity = (EntityPlayerMP) player;
		} else if (side == Side.CLIENT) {
			EntityClientPlayerMP playerEntity = (EntityClientPlayerMP) player;
			playerEntity.sendQueue.addToSendQueue(packet);
		} else {

		}
	}

	public void decreaseFatigue(EntityPlayer player, int amount) {
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 3) {
			amount = amount * 2;
		} else if (difficulty == 1) {
			amount = (int) (amount * 0.5);
		}
		Integer amount1 = (Fatigue.fatigue.get(player.username) - amount);
		if (amount1 < 0) {
			amount1 = 0;
		}

		Fatigue.fatigue.remove(player);
		Fatigue.fatigue.put(player.username, amount1);
		sendPacket(player, amount1);
	}

	public void increaseFatigue(EntityPlayer player, int amount) {
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 1) {
			amount = amount * 2;
		} else if (difficulty == 3) {
			amount = (int) (amount * 0.5);
		}
		Integer amount1 = (Fatigue.fatigue.get(player.username) + amount);
		if (amount1 > 65535) {
			amount1 = 65535;
		}

		Fatigue.fatigue.remove(player);
		Fatigue.fatigue.put(player.username, amount1);
		sendPacket(player, amount1);
	}

	public int getFatigue(String username) {
		int amount = Fatigue.fatigue.get(username);
		return amount;
	}

	public void initFatigue(EntityPlayer player, int amount) {
		int difficulty = player.getEntityWorld().difficultySetting;
		if ((Integer) amount == null) {
			if (difficulty == 3) {
				amount = 30000;
				Fatigue.fatigue.put(player.username, amount);
			} else {
				amount = 60000;
				Fatigue.fatigue.put(player.username, amount);
			}
		} else {
			Fatigue.fatigue.put(player.username, amount);
			/*
			 * if (amount <= 3000){ player.addPotionEffect(new
			 * PotionEffect(Potion.digSlowdown.getId(), 1200, 2));
			 * player.addPotionEffect(new
			 * PotionEffect(Potion.moveSlowdown.getId(), 1200, 2)); } else if
			 * (amount >= 54000){ player.addPotionEffect(new
			 * PotionEffect(Potion.digSpeed.getId(), 1200, 2));
			 * player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),
			 * 1200, 2)); }
			 */
		}
		sendPacket(player, amount);

	}

}
