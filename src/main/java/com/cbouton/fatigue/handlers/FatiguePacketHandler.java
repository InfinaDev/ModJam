package com.cbouton.fatigue.handlers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import org.lwjgl.Sys;

import com.cbouton.fatigue.lib.Statics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class FatiguePacketHandler implements IPacketHandler {
	private int fatigue;

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals(Statics.CHANNEL)) {
			handlePacket(packet, (EntityPlayer) player);
		}

	}

	@SuppressWarnings("unused")
	private void handlePacket(Packet250CustomPayload packet, EntityPlayer player) {
		// TODO deal with packet data
		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));
		int amount;

		try {
			amount = inputStream.readInt();
			System.out.println(player.username + ": " + amount);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	
	public int getFatigue() {
		return fatigue;
	}

}
