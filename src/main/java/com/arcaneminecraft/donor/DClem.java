package com.arcaneminecraft.donor;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DClem implements CommandExecutor {
	private static final String RED = ChatColor.RED + "";
	private static final String GRAY = ChatColor.GRAY + "";
	private static final String GREEN = ChatColor.GREEN + "";
	private static final String YELLOW = ChatColor.YELLOW + "";
	private static final String GOLD = ChatColor.GOLD + "";
	private static final String BOLD = ChatColor.BOLD + "";

	// TODO: Fix up this code by optimizing it.  This is extremely inefficient as it's written now.
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Random random = new Random();
		ArrayList<String> smallList = new ArrayList<String>();

		smallList.add("Build a house for a zombie! Zombies are human too.");
		smallList.add("Build a camp in the forest! AKA \"Going Canadian\"?");
		smallList.add("Build an entrance to a mine! It's half of the game's name, better make it pretty.");
		smallList.add("Build a garden! Remember that opium comes from poppies.");
		smallList.add("Build a graveyard! 2spooky4me?");
		smallList.add(
				"Build a time capsule by burying a chest somewhere! Don't forget the \"ayy lmao\" paper in there.");
		smallList.add("Build a fountain! Bonus point if it doesn't look phallic.");
		smallList.add("Build a tent! Camping like a boss.");
		smallList.add("Build a dirthouse. Gotta start somewhere, amiright?");

		String smallrandom = smallList.get(random.nextInt(smallList.size() - 1));

		ArrayList<String> bigList = new ArrayList<String>();

		bigList.add("Build a lighthouse! No evil shall escape your sight!");
		bigList.add("Build a ship! Agentred will be so jealous of your skills.");
		bigList.add("Build a PvP arena! Watching your friends murder eachother in your own arena is priceless.");
		bigList.add("Build a monument to DClem's glory! Then give him diamonds.");
		bigList.add("Build a treehouse! \"Kids NExt Door\", anyone?");
		bigList.add(
				"Build a watchtower! Wooden if you live in the forest, stone if you live in the mountains, clay if you live in the sea.");
		bigList.add("Build an inn! Don't let any creepers in.");
		bigList.add("Build an Egyptian themed build! Then walk like an Egyptian.");
		bigList.add("Build an Asian themed build! Senpai will surely notice you after that!");
		bigList.add("Build a 1/1 scale replica of a real or fictional build! No inspiration? Just copy.");

		String bigrandom = bigList.get(random.nextInt(bigList.size() - 1));

		ArrayList<String> redList = new ArrayList<String>();

		redList.add("Build a sorting system for your mine! Then give your diamonds to DClem.");
		redList.add("Build a nano farm! Sometimes, smaller can be better.");
		redList.add("Build a 3x3 secret door to a secret part of your base! So fancy!");
		redList.add("Build a \"panic room\" in your base, fully equipped with what you need to survive an apocalypse!");
		redList.add("Build a nether hub with portals to 3 different biomes! A whole new world!");
		redList.add(
				"Build a farm with everything that is farmable! Ain't nobody got time to travel for cacti or vines, amiright?");
		redList.add("Build an armor for mining! Dig it hard, but use blast protection ;D");
		redList.add("Build a fully equipped enchant-station! It's a kind of magic.");
		redList.add("Build a wool farm with every wool type! Then paint with all the colors of the w...wool.");

		String redrandom = redList.get(random.nextInt(bigList.size() - 1));

		ArrayList<String> comList = new ArrayList<String>();

		comList.add(
				"Build a portal and put it on one of the Nether Highways! Orange Highway is the best, just sayin'.");
		comList.add("Build a shop in the Market Ravine! And then shop 'til your drop... in the Ravine.");
		comList.add(
				"Build a road linking up your base to one of the Overworld Roads! A journey of a thousand miles begins with a single step.");
		comList.add("Check Spawn for any eventual griefs! Arcane's equivalent of \"citizen's arrest\"?");
		comList.add(
				"Help a new player find his way around Spawn and Arcane! We were all noobs in the beginning. Except for Agentred, of course.");
		comList.add("Give gifts to 3 players through the mailboxes at Spawn! So nice of you <3");
		comList.add(
				"Open a RolePlay thread on the forum and invent a lore for your village/base/settlement! The People's Republic of Taiga will crush you anyway.");
		comList.add("Fill the gear and food chests at spawn! Nobody likes to die on his/her first night.");
		comList.add("Ask around if anyone wants help with building or ressource gathering, and then help them!");

		String comrandom = comList.get(random.nextInt(bigList.size() - 1));

		String intro = GRAY + BOLD + ">" + GREEN + BOLD + "> ";


		if (args.length == 0) {

			sender.sendMessage(intro + GOLD + BOLD + "DClem's Anti-Boredom Build Ideas!" + RED + BOLD + " V1.0");
			sender.sendMessage(
					intro + GRAY + "For " + YELLOW + "Small Building Ideas," + GRAY + " Type /dclem " + "small");
			sender.sendMessage(intro + GRAY + "For " + YELLOW + "Big Building Ideas," + GRAY + " Type /dclem " + "big");
			sender.sendMessage(intro + GRAY + "For " + YELLOW + "Redstone Building Ideas," + GRAY + " Type /dclem "
					+ "redstone");
			sender.sendMessage(
					intro + GRAY + "For " + YELLOW + "Community Building Ideas," + GRAY + " Type /dclem community");
		}

		if (args.length == 1) {

			switch (args[0].toLowerCase()) {
			case "small":
				sender.sendMessage(intro + GOLD + "DClem's Build Idea: " + GRAY + smallrandom);
				break;

			case "big":
				sender.sendMessage(intro + GOLD + "DClem's Build Idea: " + GRAY + bigrandom);
				break;

			case "redstone":
				sender.sendMessage(intro + GOLD + "DClem's Build Idea: " + GRAY + redrandom);
				break;

			case "community":
				sender.sendMessage(intro + GOLD + "DClem's Build Idea: " + GRAY + comrandom);
				break;
			}
		}
		return true;
	}

}
