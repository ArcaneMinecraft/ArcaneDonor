package com.arcaneminecraft.donor;

import com.arcaneminecraft.donor.players.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ArcaneDonor extends JavaPlugin {
    private static ArcaneDonor instance;

    public static ArcaneDonor getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        ArcaneDonor.instance = this;

        saveDefaultConfig();

        Bbycake bbycake = new Bbycake();
        DClem dclem = new DClem();
        DragonDLV dragon_dlv = new DragonDLV(this);
        LordStaples lordStaples = new LordStaples();
        SharpshootingAce sharpshootingace = new SharpshootingAce();
        Saeri_ saeri = new Saeri_();
        SimonOrJ simonorj = new SimonOrJ();
        Ytorgonak ytorgonak = new Ytorgonak();

        getCommand("bbycake")           .setExecutor(bbycake);
        getCommand("dclem")             .setExecutor(dclem);
        getCommand("dragon_dlv")        .setExecutor(dragon_dlv);
        getCommand("lordstaples")       .setExecutor(lordStaples);
        getCommand("sharpshootingace")  .setExecutor(sharpshootingace);
        getCommand("saeri_")            .setExecutor(saeri);
        getCommand("simonorj")          .setExecutor(simonorj);
        getCommand("ytorgonak")         .setExecutor(ytorgonak);

        getServer().getPluginManager()  .registerEvents(dragon_dlv, this);
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    private static final String DONOR_STRING = "Donor commands: /bbycake, /dclem, /dragon_dlv, /monreflexion, /sharpshootingace, /simonorj, /ytorgonak";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(DONOR_STRING);
        return true;
    }
}
