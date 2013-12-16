package com.cbouton.fatigue.handlers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

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
	public HashMap<String, Short> fatigue = new HashMap<String, Short>(); //TODO BROKEN WITH SHORT - FIX WITH INT/MAX VALUE 65535.

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
		// TODO: Decrease players Fatigue by amount;
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 3) {
			amount = amount * 2;
		} else if (difficulty == 1) {
			amount = (int) (amount * 0.5);
		}
		Short amount1 = (short) (fatigue.get(player.username) - amount);
		/*if (amount1 <= 3000){
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 1200, 2));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 1200, 2));
		} else if (amount1 >= 54000){
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1200, 2));
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1200, 2));
		}*/
		
		fatigue.remove(player);
		fatigue.put(player.username, amount1);
		sendPacket(player, amount1);
	}

	public void increaseFatigue(EntityPlayer player, int amount) {
		// TODO: Increase players Fatigue by amount;
		int difficulty = player.getEntityWorld().difficultySetting;
		if (difficulty == 1) {
			amount = amount * 2;
		} else if (difficulty == 3) {
			amount = (int) (amount * 0.5);
		}
		Short amount1 = (short) (fatigue.get(player.username) + amount);
		/*if (amount1 <= 3000 && !player.capabilities.isCreativeMode){
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 1200, 2));
			player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 1200, 2));
		} else if (amount1 >= 54000 && !player.capabilities.isCreativeMode){
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1200, 2));
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1200, 2));
		}*/
		
		fatigue.remove(player);
		fatigue.put(player.username, amount1);
		sendPacket(player, amount1);
	}

	public int getFatigue(EntityPlayer player) {
		// TODO: get Fatigue amount by player;
		int amount = fatigue.get(player.username);
		return amount;
	}

	public void initFatigue(EntityPlayer player, int amount) {
		// TODO set player fatigue upon join
		int difficulty = player.getEntityWorld().difficultySetting;
		if ((Integer) amount == null) {
			if (difficulty == 3) {
				amount = 30000;
				fatigue.put(player.username, (short) amount);
			} else {
				amount = 60000;
				fatigue.put(player.username, (short) amount);
			}
		} else {
			fatigue.put(player.username, (short) amount);
			/*if (amount <= 3000){
				player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 1200, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 1200, 2));
			} else if (amount >= 54000){
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1200, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1200, 2));
			}*/
		}
		sendPacket(player, amount);

	}

}
