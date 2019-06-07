package com.arcaneminecraft.donor.players;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Bbycake implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("arcane.bbycake")) {
            sender.sendMessage("You are bbycake.");
        } else {
            sender.sendMessage("You are not bbycake.");
        }
        return true;
    }
}
