package com.cbouton.fatigue;

import java.util.ArrayList;
import java.util.List;

import com.cbouton.fatigue.handlers.FatigueHandler;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class FatigueCommand implements ICommand {
	FatigueHandler handler = new FatigueHandler();

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
		return null;
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (icommandsender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) icommandsender;
			int amount = Integer.parseInt(astring[1]);
			System.out.println(player.username + ": " + amount);
			if (astring[0].equalsIgnoreCase("add")) {
				handler.increaseFatigue(player, amount);
			} else if (astring[0].equalsIgnoreCase("subtract")) {
				handler.decreaseFatigue(player, amount);
			} else {
				getCommandUsage(icommandsender);
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
