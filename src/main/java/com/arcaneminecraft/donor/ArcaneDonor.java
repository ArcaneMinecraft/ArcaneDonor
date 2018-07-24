package com.arcaneminecraft.donor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ArcaneDonor extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        DragonDLV dragonDLV = new DragonDLV(this);

        getCommand("bbycake").setExecutor(new Bbycake());
        getCommand("dclem").setExecutor(new DClem());
        getCommand("dragon_dlv").setExecutor(dragonDLV);
        getCommand("monreflexion").setExecutor(new MonReflexion());
        getCommand("sharpshootingace").setExecutor(new SharpshootingAce());
        getCommand("simonorj").setExecutor(new SimonOrJ(this));
        getCommand("ytorgonak").setExecutor(new Ytorgonak());

        getServer().getPluginManager().registerEvents(dragonDLV, this);
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("donor")) {
            sender.sendMessage("Donor commands: /bbycake, /dclem, /dragon_dlv, /monreflexion, /sharpshootingace, /simonorj, /ytorgonak");
            return true;
        }
        return false;
    }
}
