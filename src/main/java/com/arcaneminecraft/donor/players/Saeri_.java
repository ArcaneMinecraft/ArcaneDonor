package com.arcaneminecraft.donor.players;

import com.arcaneminecraft.donor.ArcaneDonor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Saeri_ implements TabExecutor {
    private static final ChatColor THEME_COLOR = ChatColor.GOLD;
    private final Random rand = new Random();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int x;
        int z;

        if (sender instanceof Player) {
            WorldBorder wb = ((Player) sender).getWorld().getWorldBorder();
            int a = (int) wb.getSize();
            int zz = a/2;
            Location c = wb.getCenter();
            x = rand.nextInt(a) + c.getBlockX() - zz;
            z = rand.nextInt(a) + c.getBlockZ() - zz;
        } else {
            x = 0;
            z = 0;
        }

        TextComponent send = new TextComponent();
        send.setColor(ChatColor.GRAY);

        TextComponent a = new TextComponent("Saeri v1.1");
        a.setColor(THEME_COLOR);
        send.addExtra(a);

        a = new TextComponent(" <><> ");
        a.setColor(ChatColor.DARK_GRAY);
        send.addExtra(a);

        send.addExtra("In this world at ");

        a = new TextComponent("x:" + x);
        a.setColor(THEME_COLOR);
        send.addExtra(a);

        send.addExtra(", ");

        a = new TextComponent("z:" + z);
        a.setColor(THEME_COLOR);
        send.addExtra(a);

        send.addExtra(", build ");

        a = new TextComponent(aThing());
        a.setColor(THEME_COLOR);
        send.addExtra(a);

        send.addExtra("!");

        if (sender instanceof Player)
            ((Player) sender).spigot().sendMessage(send);
        else
            sender.sendMessage(send.toPlainText());

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return Collections.emptyList();
    }

    private String aThing() {
        // TODO: Don't add "an" and "a" on things that are plural
        String a = dictionary[rand.nextInt(dictionary.length)];
        switch (a.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return "an " + a;
            default:
                return "a " + a;
        }
    }

    private final String[] dictionary = {
            "barn",
            "farmhouse",
            "greenhouse",
            "water tower",
            "well",
            "inn",
            "market",
            "igloo",
            "windmill",
            "lighthouse",
            "roadside stall",
            "train",
            "horse-pulled carriage",
            "shrine",
            "temple",
            "church",
            "cemetary",
            "fort",
            "arena",
            "nuclear reactor",
            "great wall",
            "wizard's tower",
            "catacomb",
            "statue",
            "fountain",
            "mine",
            "airship",
            "pool",
            "dam",
            "camp",
            "arch",
            "floating island",
            "garden",
            "pyramid",
            "unusual tree",
            "crater",
            "hand reaching out of the ground",
            "ruins",
            "pub",
            "wicker man",
            "canal",
            "vault",
            "watermill",
            "nether colony",
            "ender colony",
            "maze",
            "massive tree",
            "bath house",
            "aqueduct",
            "bridge",
            "watchtower",
            "burial mound",
            "moat",
            "terraces",
            "clocktower",
            "crypt",
            "cannon",
            "park",
            "stonehenge",
            "skeleton",
            "gazebo",
            "houseboat",
            "observatory",
            "quarry",
            "dungeon",
            "lake"
    };
}
