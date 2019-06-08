package com.arcaneminecraft.donor.players;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Agentred100 implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Useful username command
        // "very useful i give a perfect 5/7" -Simon, 2016
        // "this is too good to remove" -Simon, 2018
        // "in retrospect, i'm not sure if this should stay here. This is moving to the donors" -Simon, 2019
        // "finally, it's in the very place where it belongs" -Simon, June 2019
        if (!(sender instanceof Player)) {
            sender.sendMessage("You'll always be named Server.");
            return true;
        }

        String name = ((Player) sender).getDisplayName();

        Random randy = new Random();

        String[] list = {
                "It looks like your username is " + name + ".",
                "Your username is " + name + ".",
                "Your username is not Agentred100.",
                "Username: " + name + ".",
                ChatColor.RED + "[UserAgent] " + ChatColor.GRAY + name + ".",
                ChatColor.GOLD + "[UserAgent]" + ChatColor.GRAY + " At the moment, your username is " + name + ".",
                ChatColor.GOLD + "YOUR USERNAME IS " + ChatColor.RED + name + ".",
                name
        };

        String r = list[randy.nextInt(list.length)];

        sender.sendMessage(ChatColor.GRAY + r);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return Collections.emptyList();
    }
}
