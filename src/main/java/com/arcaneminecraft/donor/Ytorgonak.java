package com.arcaneminecraft.donor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.arcaneminecraft.ArcaneCommons;

class Ytorgonak implements CommandExecutor{
	private static final String YT = ChatColor.GOLD + "[From: ytorgonak] " + ChatColor.GRAY;
	private static final String WW = ChatColor.BLUE + "//";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(ChatColor.BLUE + "---- " + ChatColor.GRAY
					+ "ytorgonakPlugin 2.0" + ChatColor.BLUE + " ----");
			sender.sendMessage(WW
					+ ChatColor.GRAY
					+ " This is the menu for the ytorgonak plugin - Version 2.0");
			sender.sendMessage(WW + ChatColor.GRAY
					+ " /ytor id - Let ytorgonak identify your item");
			sender.sendMessage(WW + ChatColor.GRAY
					+ " /ytor loc - Let ytorgonak give you your location");
			return true;
		}
		if (args.length == 1) {
			// Must be a player beyond this point
			if (!(sender instanceof Player)) {
				sender.sendMessage(ArcaneCommons.noConsoleMsg());
				return true;
			}
			Player p = (Player)sender;
			
			if (args[0].equalsIgnoreCase("id")) {
				ItemStack item = p.getInventory().getItemInMainHand();
				sender.sendMessage(YT + "That's a(n) "
						+ item.getType() + " - "
						+ item.getAmount() + " of 'em!");
			} else if (args[0].equalsIgnoreCase("loc")) {
				int x = p.getLocation().getBlockX();
				int y = p.getLocation().getBlockY();
				int z = p.getLocation().getBlockZ();

				sender.sendMessage(YT + "Hey! You're located at " + x + "x, "
						+ y + "y, " + z + "z!");
			}
			return true;
		}
		return false;
	}
}
