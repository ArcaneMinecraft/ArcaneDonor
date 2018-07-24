package com.arcaneminecraft.donor;

import com.google.common.collect.ImmutableList;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

public class DragonDLV implements TabExecutor, Listener {
    private static final UUID DLV_UUID = UUID.fromString("47add2c9d2554fb18be3dfee3ec8ac97");
    private final ArcaneDonor plugin;

    DragonDLV(ArcaneDonor plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        boolean self;

        if (args.length != 0 && args[0].equalsIgnoreCase("me") && sender instanceof Player) {
            p = (Player) sender;
            self = true;
        } else {
            p = plugin.getServer().getPlayer(DLV_UUID);
            self = false;
        }

        int deaths, timeSinceDeath;

        if (p == null) {
            deaths = plugin.getConfig().getInt("dragon-dlv.deaths", 0);
            timeSinceDeath = plugin.getConfig().getInt("dragon-dlv.time-since-death", 0);
        } else {
            deaths = p.getStatistic(Statistic.DEATHS);
            timeSinceDeath = p.getStatistic(Statistic.TIME_SINCE_DEATH); // milliseconds
        }

        if (!self)
            sender.sendMessage("Last time, " + plugin.getConfig().getString("dragon-dlv.last-death", "Dragon_DLV died"));

        sender.sendMessage("So far, " + (self ? "you have" : "Dragon_DLV has") + " died " + deaths + " number of times on Arcane");
        sender.sendMessage((self ? "You have" : "Dragon_DLV has") + "n't died for " + time(timeSinceDeath));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return ImmutableList.of("me");
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
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDragonDeath(PlayerDeathEvent e) {
        if (e.getEntity().getUniqueId() == DLV_UUID) {
            plugin.getConfig().set("dragon-dlv.last-death", e.getDeathMessage());
        }
    }
}
