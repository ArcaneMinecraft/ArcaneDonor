package com.arcaneminecraft.donor;

import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MonReflexion implements CommandExecutor {
	private final Random rand = new Random();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		int x = rand.nextInt(7894) - 3812;
		int z = rand.nextInt(7894) - 3812;
		
		sender.sendMessage("At x:" + x + ", z:" + z + ", build " + aThing() + "!");
		
		return true;
	}
	
	private String aThing() {
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
