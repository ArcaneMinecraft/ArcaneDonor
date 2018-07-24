package com.arcaneminecraft.donor;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Formatter;
import java.util.Random;

public class SimonOrJ implements CommandExecutor {
    private final ArcaneDonor plugin;
    private static final String[] FORMAT = {
            "You roar at Simon after %s",
            "Meow meow %s meow!",
            "I ain't lying when I said %s said it first!",
            "%s was here",
            "%s already ran this command!",
            "Too late! %s claimed this before you!"
    };
    /**
     * Player who ran this command last
     */
    private String lastPlayer;
    /**
     * Player who is running the command now
     */
    private String currentPlayer;

    SimonOrJ(ArcaneDonor plugin) {
        this.plugin = plugin;
        this.lastPlayer = "Server";
        this.currentPlayer = plugin.getConfig().getString("simonorj.last", "Server");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Random rand = new Random();
        Formatter f = new Formatter();

        if (!currentPlayer.equals(sender.getName())) {
            lastPlayer = currentPlayer;
            currentPlayer = (sender instanceof Player) ? sender.getName() : "Server";
            plugin.getConfig().set("simonorj.last", currentPlayer);
        }

        sender.sendMessage(ChatColor.DARK_GREEN + "[SimonOrJ] " + ChatColor.AQUA
                + f.format(FORMAT[rand.nextInt(FORMAT.length)], lastPlayer));

        return true;
    }
}
