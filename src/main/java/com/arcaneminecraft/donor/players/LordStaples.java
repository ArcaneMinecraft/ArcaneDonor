package com.arcaneminecraft.donor.players;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class LordStaples implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.YELLOW.toString() + ChatColor.BOLD + '>'
                + ChatColor.DARK_GRAY + ChatColor.BOLD + '>'
                + ChatColor.RED + ChatColor.BOLD  + " Glory to the Auric Empire! "
                + ChatColor.DARK_GRAY + ChatColor.BOLD + '<'
                + ChatColor.YELLOW + ChatColor.BOLD + '<');
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
