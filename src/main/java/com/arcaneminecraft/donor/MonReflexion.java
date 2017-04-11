package com.arcaneminecraft.donor;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class MonReflexion implements CommandExecutor {
	private final ChatColor THEME_COLOR = ChatColor.GOLD;
	private final Random rand = new Random();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int x = rand.nextInt(7894) - 3812;
		int z = rand.nextInt(7894) - 3812;
		
		TextComponent send = new TextComponent("At ");
		send.setColor(ChatColor.GRAY);
		
		TextComponent a = new TextComponent("x:" + x);
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
		
		send.addExtra("! ");
		
		a = new TextComponent("[link]");
		a.setColor(ChatColor.DARK_AQUA);
		send.addExtra(a);
		
		send.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://game.arcaneminecraft.com/dynmap/?worldname=Main&mapname=flat&zoom=6&x=" + x + "&y=64&z=" + z));
		
		if (sender instanceof Player)
			((Player)sender).spigot().sendMessage(send);
		else
			sender.sendMessage(send.toPlainText());
		
		return true;
	}
	
	private String aThing() {
		// TODO: Don't add "an" and "a" on things that are plural
		String a = dictionary[rand.nextInt(dictionary.length)];
		switch(a.charAt(0)) {
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
