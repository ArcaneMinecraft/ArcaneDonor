package com.arcaneminecraft.donor;

import com.arcaneminecraft.api.ArcaneColor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class ArcaneDonor extends JavaPlugin {

    @Override
    public void onEnable() {
        DragonDLV dragonDLV = new DragonDLV(this);

        getCommand("bbycake").setExecutor(new Bbycake());
        getCommand("dclem").setExecutor(new DClem());
        getCommand("dragon_dlv").setExecutor(dragonDLV);
        getCommand("monreflexion").setExecutor(new MonReflexion());
        getCommand("sharpshootingace").setExecutor(new SharpshootingAce());
        getCommand("simonorj").setExecutor(new SimonOrJ());
        getCommand("ytorgonak").setExecutor(new Ytorgonak());

        getServer().getPluginManager().registerEvents(dragonDLV, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("donor")) {

            sender.sendMessage("Donor commands: /bbycake, /dclem, /dragon_dlv, /monreflexion, /sharpshootingace, /simonorj, /ytorgonak");
            // TODO: Get list of all donors from LuckPerms
            // TODO: Figure out how to get a list of donors from LuckPerms as there seem to be no method for it.



            return true;
        }
        return false;
    }
}
