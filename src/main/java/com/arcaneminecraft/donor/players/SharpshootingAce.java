package com.arcaneminecraft.donor.players;

import com.arcaneminecraft.api.ArcaneText;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SharpshootingAce implements TabExecutor {
    private static final String GRAY = ChatColor.GRAY + "";
    private static final String WHITE = ChatColor.WHITE + "";
    private static final String GREEN = ChatColor.GREEN + "";
    private static final String GOLD = ChatColor.GOLD + "";
    private static final String ENCHANT_CMD = "enchant";
    private static final String INFO_CMD = "info";

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
                sender.spigot().sendMessage(ArcaneText.noConsoleMsg());
                return true;
            }
            Player p = (Player) sender;

            if (args[0].equalsIgnoreCase(ENCHANT_CMD)) {
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
            } else if (args[0].equalsIgnoreCase(INFO_CMD)) {

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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> ret = new ArrayList<>();

        if (args.length == 1) {
            if (ENCHANT_CMD.startsWith(args[0].toLowerCase()))
                ret.add(ENCHANT_CMD);
            if (INFO_CMD.startsWith(args[0].toLowerCase()))
                ret.add(INFO_CMD);
        }

        return ret;
    }
}
