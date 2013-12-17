package com.cbouton.fatigue;

import java.util.List;

import com.cbouton.fatigue.handlers.FatigueHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class FatigueCommand implements ICommand {

	public FatigueCommand() {
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		return "fatigue";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/fatigue <add|subtract> <value>";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;
			if (astring.length == 2) {
				int amount = Integer.parseInt(astring[1]);
				if (astring[0].equalsIgnoreCase("add")) {
					FatigueHandler.increaseFatigue(player, amount);
				} else if (astring[0].equalsIgnoreCase("subtract")) {
					FatigueHandler.decreaseFatigue(player, amount);
				} else {
					player.sendChatToPlayer(ChatMessageComponent.createFromText(getCommandUsage(icommandsender)).setColor(EnumChatFormatting.RED));
				}
			} else {
				player.sendChatToPlayer(ChatMessageComponent.createFromText(getCommandUsage(icommandsender)).setColor(EnumChatFormatting.RED));
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return Minecraft.getMinecraft().getIntegratedServer().isCommandBlockEnabled();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}

}
