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
        sender.sendMessage(ChatColor.RED + ">> Glory to the Auric Empire! <<");
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.stopSound(Sound.ENTITY_LIGHTNING_BOLT_THUNDER); // TODO: Test if this works
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
