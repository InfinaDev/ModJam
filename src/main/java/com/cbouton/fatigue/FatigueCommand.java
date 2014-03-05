package com.cbouton.fatigue;

import com.cbouton.fatigue.handlers.FatigueHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class FatigueCommand extends CommandBase {

	public FatigueCommand() {
	}

	@Override
	public int compareTo(Object o) {
        return this.getCommandName().compareTo(((ICommand) o).getCommandName());
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
	public void processCommand(ICommandSender sender, String[] astring) {
		if (sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			if (astring.length == 2) {
				int amount = Integer.parseInt(astring[1]);
				if (astring[0].equalsIgnoreCase("add")) {
					FatigueHandler.increaseFatigue(player, amount);
				} else if (astring[0].equalsIgnoreCase("subtract")) {
					FatigueHandler.decreaseFatigue(player, amount);
				} else {
					throw new WrongUsageException(getCommandUsage(sender));
				}
			} else {
                throw new WrongUsageException(getCommandUsage(sender));
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
