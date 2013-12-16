package com.cbouton.fatigue.handlers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import org.lwjgl.Sys;

import com.cbouton.fatigue.lib.Statics;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.SideOnly;

public class FatiguePacketHandler implements IPacketHandler {
	public static int fatigue;

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(Statics.CHANNEL)) {
			handlePacket(packet, (EntityPlayer) player);
		}

	}

	@SuppressWarnings("unused")
	private void handlePacket(Packet250CustomPayload packet, EntityPlayer player) {
		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));
		int amount;

		try {
			amount = inputStream.readInt();
			System.out.println(player.username + ": " + amount);
			setFatigue(amount);			

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	
	public void setFatigue(int level) {
		fatigue = level;
		System.out.println(level);
	}
	
	public static int getFatigue() {
		return fatigue;
	}

}
