package com.arcaneminecraft.donor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.arcaneminecraft.api.ArcaneCommons;

class SharpshootingAce implements CommandExecutor {
	private static final String GRAY = ChatColor.GRAY + "";
	private static final String WHITE = ChatColor.WHITE + "";
	private static final String GREEN = ChatColor.GREEN + "";
	private static final String GOLD = ChatColor.GOLD + "";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // sharp
		if (args.length == 0) {

			sender.sendMessage(GOLD + "---- SharpshootingAce Plugin 1.0.0 ----");
			sender.sendMessage(GOLD
					+ "[\\]"
					+ GRAY
					+ " This is the menu for SharpPlug. The command are as follows:");
			sender.sendMessage(GOLD + "[\\] " + GREEN + "/sharp enchant " + GRAY
					+ "List the enchantments for an item");
			sender.sendMessage(GOLD + "[\\] " + GREEN + "/sharp info " + GRAY
					+ "View your information");
			return true;
		}
		if (args.length == 1) {
			// Must be a player beyond this point
			if (!(sender instanceof Player)) {
				sender.sendMessage(ArcaneCommons.noConsoleMsg());
				return true;
			}
			Player p = (Player)sender;
			
			if (args[0].equalsIgnoreCase("enchant")) {
				ItemStack item = p.getInventory().getItemInMainHand();
				if (item.getEnchantments().size() > 0) {
					sender.sendMessage(GOLD
							+ "---- SharpPlug Enchantment Lookup ---- ");
					sender.sendMessage(GOLD + "[\\] " + GREEN + "Item: " + WHITE
							+ item.getType());
					sender.sendMessage(GOLD
							+ "[\\] "
							+ GREEN
							+ "Enchantment: "
							+ WHITE
							+ item.getEnchantments()
									.toString());
				} else {
					sender.sendMessage(GOLD + "[\\] "
							+ "SharpPlug Error Report: " + ChatColor.RED
							+ "1 Error(s) detected!");
					sender.sendMessage(GOLD + "[\\] Code: " + GRAY
							+ "ItemNotEnchanted=true");
					sender.sendMessage(GOLD + "[\\] English: " + GRAY
							+ "That item is not enchanted!");
				}
			} else if (args[0].equalsIgnoreCase("info")) {

				sender.sendMessage(GOLD + "---- SharpPlug Player Lookup ----");
				sender.sendMessage(GOLD + "[\\] " + GREEN + "Username: " + GRAY
						+ p.getDisplayName());
				sender.sendMessage(GOLD + "[\\] " + GREEN + "Health: " + GRAY
						+ p.getHealth());
				sender.sendMessage(GOLD + "[\\] " + GREEN + "Experience: "
						+ GRAY + p.getExp());
			}
			return true;
		}
		return false;
	}
}
