package com.arcaneminecraft.donor;

import com.arcaneminecraft.donor.players.*;
import org.bukkit.ChatColor;
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
        Sb3 sb3 = new Sb3();
        SimonOrJ simonorj = new SimonOrJ();
        Ytorgonak ytorgonak = new Ytorgonak();

        getCommand("bbycake")           .setExecutor(bbycake);
        getCommand("dclem")             .setExecutor(dclem);
        getCommand("dragon_dlv")        .setExecutor(dragon_dlv);
        getCommand("lordstaples")       .setExecutor(lordStaples);
        getCommand("sharpshootingace")  .setExecutor(sharpshootingace);
        getCommand("saeri_")            .setExecutor(saeri);
        getCommand("sb3")               .setExecutor(sb3);
        getCommand("simonorj")          .setExecutor(simonorj);
        getCommand("ytorgonak")         .setExecutor(ytorgonak);

        getServer().getPluginManager()  .registerEvents(dragon_dlv, this);
        getServer().getPluginManager()  .registerEvents(sb3, this);
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    private static final String DONOR_STRING = ChatColor.GOLD + "[ArcaneSurvival]" + ChatColor.GRAY + " Donor commands: /bbycake /dclem /dragon_dlv /lordstaples /sharpshootingace /saeri_ /sb3 /simonorj /ytorgonak";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(DONOR_STRING);
        return true;
    }
}
