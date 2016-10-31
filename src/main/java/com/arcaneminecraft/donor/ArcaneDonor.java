package com.arcaneminecraft.donor;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ArcaneDonor extends JavaPlugin{
	private static final String HELP[][][] = {
			// TODO: insert custom donor commandshelp
	};
	
	@Override
	public void onEnable() {
		getServer().getLogger().warning("MEAN MODE ACTIVATED");
	}

	@Override
	public void onDisable() {
		getServer().getLogger().warning("MEAN MODE has run away.");
	}
	
	private final String yt = ChatColor.GOLD + "[From: ytorgonak] " + ChatColor.GRAY;
	private final String ww = ChatColor.BLUE + "//";
	private final String red = ChatColor.RED + "";
	private final String gray = ChatColor.GRAY + "";
	private final String white = ChatColor.WHITE + "";
	private final String green = ChatColor.GREEN + "";
	private final String yellow = ChatColor.YELLOW + "";
	private final String gold = ChatColor.GOLD + "";
	private final String bold = ChatColor.BOLD + "";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		// TODO: The donor commands should be made into their own plugin(s)
		//   Consider it done ~Simon
		if (cmd.getName().equalsIgnoreCase("sharpshootingace")) {
			if (args.length == 0) {

				p.sendMessage(gold + "---- SharpshootingAce Plugin 1.0.0 ----");
				p.sendMessage(gold
						+ "[\\]"
						+ gray
						+ " This is the menu for SharpPlug. The command are as follows:");
				p.sendMessage(gold + "[\\] " + green + "/sharp enchant " + gray
						+ "List the enchantments for an item");
				p.sendMessage(gold + "[\\] " + green + "/sharp info " + gray
						+ "View your information");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("enchant")) {
					if (p.getItemInHand().getEnchantments().size() > 0) {
						p.sendMessage(gold
								+ "---- SharpPlug Enchantment Lookup ---- ");
						p.sendMessage(gold + "[\\] " + green + "Item: " + white
								+ p.getItemInHand().getType());
						p.sendMessage(gold
								+ "[\\] "
								+ green
								+ "Enchantment: "
								+ white
								+ p.getItemInHand().getEnchantments()
										.toString());
					} else {
						p.sendMessage(gold + "[\\] "
								+ "SharpPlug Error Report: " + ChatColor.RED
								+ "1 Error(s) detected!");
						p.sendMessage(gold + "[\\] Code: " + gray
								+ "ItemNotEnchanted=true");
						p.sendMessage(gold + "[\\] English: " + gray
								+ "That item is not enchanted!");
					}
				} else if (args[0].equalsIgnoreCase("info")) {

					p.sendMessage(gold + "---- SharpPlug Player Lookup ----");
					p.sendMessage(gold + "[\\] " + green + "Username: " + gray
							+ p.getDisplayName());
					p.sendMessage(gold + "[\\] " + green + "Health: " + gray
							+ p.getHealth());
					p.sendMessage(gold + "[\\] " + green + "Experience: "
							+ gray + p.getExp());
				}
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("ytorgonak")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.BLUE + "---- " + ChatColor.GRAY
						+ "ytorgonakPlugin 2.0" + ChatColor.BLUE + " ----");
				p.sendMessage(ww
						+ ChatColor.GRAY
						+ " This is the menu for the ytorgonak plugin - Version 2.0");
				p.sendMessage(ww + ChatColor.GRAY
						+ " /ytor id - Let ytorgonak identify your item");
				p.sendMessage(ww + ChatColor.GRAY
						+ " /ytor loc - Let ytorgonak give you your location");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("id")) {
					p.sendMessage(yt + "That's a(n) "
							+ p.getItemInHand().getType() + " - "
							+ p.getItemInHand().getAmount() + " of 'em!");
				} else if (args[0].equalsIgnoreCase("loc")) {
					int x = p.getLocation().getBlockX();
					int y = p.getLocation().getBlockY();
					int z = p.getLocation().getBlockZ();

					p.sendMessage(yt + "Hey! You're located at " + x + "x, "
							+ y + "y, " + z + "z!");
				}
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("dclem")) {
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

			String intro = gray + bold + ">" + green + bold + "> ";


			if (args.length == 0) {

				p.sendMessage(intro + gold + bold + "DClem's Anti-Boredom Build Ideas!" + red + bold + " V1.0");
				p.sendMessage(
						intro + gray + "For " + yellow + "Small Building Ideas," + gray + " Type /dclem " + "small");
				p.sendMessage(intro + gray + "For " + yellow + "Big Building Ideas," + gray + " Type /dclem " + "big");
				p.sendMessage(intro + gray + "For " + yellow + "Redstone Building Ideas," + gray + " Type /dclem "
						+ "redstone");
				p.sendMessage(
						intro + gray + "For " + yellow + "Community Building Ideas," + gray + " Type /dclem community");
			}

			if (args.length == 1) {

				switch (args[0].toLowerCase()) {
				case "small":
					p.sendMessage(intro + gold + "DClem's Build Idea: " + gray + smallrandom);
					break;

				case "big":
					p.sendMessage(intro + gold + "DClem's Build Idea: " + gray + bigrandom);
					break;

				case "redstone":
					p.sendMessage(intro + gold + "DClem's Build Idea: " + gray + redrandom);
					break;

				case "community":
					p.sendMessage(intro + gold + "DClem's Build Idea: " + gray + comrandom);
					break;
				}
			}
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("bbycake")) {

			Player player = p.getPlayer();

			if (player.hasPermission("arcane.bbycake")) {

				p.sendMessage("You are bbycake.");

			} else {

				p.sendMessage("You are not bbycake.");

			}
			return true;
		}
		return false;
	}
}