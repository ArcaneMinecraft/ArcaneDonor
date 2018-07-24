package com.arcaneminecraft.donor;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DragonDLV implements TabExecutor, Listener {
    private static final UUID DLV_UUID = UUID.fromString("47add2c9d2554fb18be3dfee3ec8ac97");
    private final ArcaneDonor plugin;
    private HashMap<EntityDamageEvent.DamageCause, Integer> deathCause;

    DragonDLV(ArcaneDonor plugin) {
        this.plugin = plugin;
        this.deathCause = new HashMap<>();

        ConfigurationSection cs = plugin.getConfig().getConfigurationSection("dragon-dlv.cause");

        for (String s : cs.getKeys(true)) {
            try {
                deathCause.put(EntityDamageEvent.DamageCause.valueOf(s), cs.getInt(s));
            } catch (EnumConstantNotPresentException ignore) {}
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        if (args.length == 0) {
            p = plugin.getServer().getPlayer(DLV_UUID);
        } else if (args[0].equalsIgnoreCase("me") && sender instanceof Player) {
            p = (Player) sender;
        } else {
            sender.sendMessage("Invalid argument");
            return true;
        }

        int deaths, timeSinceDeath;
        String lastDeath = (p == null || p.getUniqueId() == DLV_UUID)
                ? plugin.getConfig().getString("dragon-dlv.last-death")
                : null;

        if (p == null) {
            deaths = plugin.getConfig().getInt("dragon-dlv.deaths");
            timeSinceDeath = plugin.getConfig().getInt("dragon-dlv.time-since-death");
        } else {
            deaths = p.getStatistic(Statistic.DEATHS);
            timeSinceDeath = p.getStatistic(Statistic.TIME_SINCE_DEATH); // milliseconds
        }

        if (lastDeath == null) sender.sendMessage("You last died " + time(timeSinceDeath) + " ago");
        else sender.sendMessage(time(timeSinceDeath) + " ago, " + lastDeath);

        sender.sendMessage("So far, " + (lastDeath == null ? "you have" : "Dragon_DLV has") + " died " + deaths + " times on Arcane");

        // Most death count

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }

    private String time(int time) {
        int diff = time / 1000;

        if (diff < 60) {
            // Within a minute
            String sec;
            if (diff < 10)
                sec = new DecimalFormat("##.##").format(time / 1000.0);
            else
                sec = String.valueOf(diff);
            sec += " second";
            if (diff != 1)
                sec += "s";
            return sec;
        } else if (diff < 3600) {
            // Within an hour
            int m = diff / 60;

            String min = String.valueOf(m) + " minute";
            if (m != 1)
                min += "s";
            return min;
        } else {
            // over an hour
            String hour = new DecimalFormat("##.##").format(diff / 3600.0) + " hour";
            if (diff/3600 != 1)
                hour += "s";
            return hour;
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDragonLeave(PlayerQuitEvent e) {
        if (e.getPlayer().getUniqueId() == DLV_UUID) {
            plugin.getConfig().set("dragon-dlv.deaths", e.getPlayer().getStatistic(Statistic.DEATHS));
            plugin.getConfig().set("dragon-dlv.time-since-death", e.getPlayer().getStatistic(Statistic.TIME_SINCE_DEATH));
            plugin.saveConfig();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDragonDeath(PlayerDeathEvent e) {
        if (e.getEntity().getUniqueId() == DLV_UUID) {
            plugin.getConfig().set("dragon-dlv.last-death", e.getDeathMessage());

            String cause = e.getEntity().getLastDamageCause().getCause().name();
            int stat = plugin.getConfig().getInt("dragon-dlv.cause." + cause, 0);
            plugin.getConfig().set("dragon-dlv.cause." + cause, stat);

        }
    }
}
