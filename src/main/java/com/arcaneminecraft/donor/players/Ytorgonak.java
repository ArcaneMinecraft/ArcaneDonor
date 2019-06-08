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

public class Ytorgonak implements TabExecutor {
    private static final String YT = ChatColor.GOLD + "[From: ytorgonak] " + ChatColor.GRAY;
    private static final String WW = ChatColor.BLUE + "//";
    private static final String ID_CMD = "id";
    private static final String LOC_CMD = "loc";

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
                sender.spigot().sendMessage(ArcaneText.noConsoleMsg());
                return true;
            }
            Player p = (Player) sender;

            if (args[0].equalsIgnoreCase(ID_CMD)) {
                ItemStack item = p.getInventory().getItemInMainHand();
                sender.sendMessage(YT + "That's a(n) "
                        + item.getType() + " - "
                        + item.getAmount() + " of 'em!");
            } else if (args[0].equalsIgnoreCase(LOC_CMD)) {
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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> ret = new ArrayList<>();

        if (args.length == 1) {
            if (ID_CMD.startsWith(args[0].toLowerCase()))
                ret.add(ID_CMD);
            if (LOC_CMD.startsWith(args[0].toLowerCase()))
                ret.add(LOC_CMD);
        }

        return ret;
    }
}
