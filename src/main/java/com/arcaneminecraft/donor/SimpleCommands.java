package com.arcaneminecraft.donor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class SimpleCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("bbycake")) {
			if (sender.hasPermission("arcane.bbycake")) {
				sender.sendMessage("You are bbycake.");
			} else {
				sender.sendMessage("You are not bbycake.");
			}
			return true;
		}
    	if (cmd.getName().equalsIgnoreCase("simonorj")) {
    		sender.sendMessage(ChatColor.RED + "You wrote something illegal. Rawr.");
    		return true;
    	}
		return false;
	}
}
