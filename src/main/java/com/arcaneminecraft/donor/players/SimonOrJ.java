package com.arcaneminecraft.donor.players;

import com.arcaneminecraft.donor.ArcaneDonor;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

public class SimonOrJ implements TabExecutor {
    private final ArcaneDonor plugin = ArcaneDonor.getInstance();
    private static final String[] FORMAT = {
            "%s says roar at Simon!",
            "%s says meow meow meow...",
            "Hunt down %s!",
            "Message %s and tell him to run this command!",
            "%s says poke (or punch?) Simon!",
            "%s says jump 2 times!",
            "%s says touch the sky!",
            "Look at %s"
    };
    /**
     * Player who ran this command last
     */
    private String lastPlayer;
    /**
     * Player who is running the command now
     */
    private String currentPlayer;

    public SimonOrJ() {
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

        sender.sendMessage(ChatColor.DARK_GREEN + "[SimonSays] " + ChatColor.AQUA
                + f.format(FORMAT[rand.nextInt(FORMAT.length)], lastPlayer));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
