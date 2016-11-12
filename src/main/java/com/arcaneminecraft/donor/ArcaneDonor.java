package com.arcaneminecraft.donor;

import java.util.ArrayList; // This is too much for what we need it for...
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.arcaneminecraft.ArcaneCommons;

public class ArcaneDonor extends JavaPlugin{
	private static final String DONORHELP[][] = {
			{"bbycake","(bbycake command)","Alias:\n /bby"},
			{"dclem","(DClem command)"},
			{"sharpshootingace","(SharpShootingAce command)","Alias:\n /sharp"},
			{"ytorgonak","(Ytorgonak command)","Alias:\n /ytor"}
	};
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DonorEvents(), this);
		
	}

	private static final String YT = ChatColor.GOLD + "[From: ytorgonak] " + ChatColor.GRAY;
	private static final String WW = ChatColor.BLUE + "//";
	private static final String RED = ChatColor.RED + "";
	private static final String GRAY = ChatColor.GRAY + "";
	private static final String WHITE = ChatColor.WHITE + "";
	private static final String GREEN = ChatColor.GREEN + "";
	private static final String YELLOW = ChatColor.YELLOW + "";
	private static final String GOLD = ChatColor.GOLD + "";
	private static final String BOLD = ChatColor.BOLD + "";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("donor")) {
			String[] footerData = {"For more help","run /help","/help"};
			return ArcaneCommons.sendCommandMenu(sender, "Donor Command Menu", DONORHELP, footerData);
		}
		
		// Slap
		if (cmd.getName().equalsIgnoreCase("slap")) {
			// No donor permission
			if (!sender.hasPermission("arcane.donor")) {
				sender.sendMessage(GRAY + "Only donors can slap people!");
				return true;
			}
			
			if (args.length == 0) {
				sender.sendMessage("Usage: /slap <player>");
			} else {
				Player target = getServer().getPlayerExact((String) args[0]);
				if (target == null) {
					sender.sendMessage(args[0] + " is not online!");
				} else {
					// Get display name? (Since Arcane doesn't use name changing...)
					getServer().broadcastMessage(YELLOW + sender.getName() + " slapped " + target.getDisplayName() + " in the face!");
				}
			}
		}

		// TODO: The donor commands should be made into their own plugin(s)
		//   Consider it done ~Simon
        
        // New TODO: Move each donor commands into its own Java class files.
        
        // sharp
		if (cmd.getName().equalsIgnoreCase("sharpshootingace")) {
			if (args.length == 0) {

				sender.sendMessage(GOLD + "---- SharpshootingAce Plugin 1.0.0 ----");
				sender.sendMessage(GOLD
						+ "[\\]"
						+ GRAY
						+ " This is the menu for SharpPlug. The command are as follows:");
				sender.sendMessage(GOLD + "[\\] " + GREEN + "/sharp enchant " + GRAY
						+ "List the enchantments for an item");
				sender.sendMessage(GOLD + "[\\] " + GREEN + "/sharp info " + GRAY
						+ "View your information");
				return true;
			}
			if (args.length == 1) {
				// Must be a player beyond this point
				if (!(sender instanceof Player)) {
					sender.sendMessage(ArcaneCommons.noConsoleMsg());
					return true;
				}
				Player p = (Player)sender;
				
				if (args[0].equalsIgnoreCase("enchant")) {
					ItemStack item = p.getInventory().getItemInMainHand();
					if (item.getEnchantments().size() > 0) {
						sender.sendMessage(GOLD
								+ "---- SharpPlug Enchantment Lookup ---- ");
						sender.sendMessage(GOLD + "[\\] " + GREEN + "Item: " + WHITE
								+ item.getType());
						sender.sendMessage(GOLD
								+ "[\\] "
								+ GREEN
								+ "Enchantment: "
								+ WHITE
								+ item.getEnchantments()
										.toString());
					} else {
						sender.sendMessage(GOLD + "[\\] "
								+ "SharpPlug Error Report: " + ChatColor.RED
								+ "1 Error(s) detected!");
						sender.sendMessage(GOLD + "[\\] Code: " + GRAY
								+ "ItemNotEnchanted=true");
						sender.sendMessage(GOLD + "[\\] English: " + GRAY
								+ "That item is not enchanted!");
					}
				} else if (args[0].equalsIgnoreCase("info")) {

					sender.sendMessage(GOLD + "---- SharpPlug Player Lookup ----");
					sender.sendMessage(GOLD + "[\\] " + GREEN + "Username: " + GRAY
							+ p.getDisplayName());
					sender.sendMessage(GOLD + "[\\] " + GREEN + "Health: " + GRAY
							+ p.getHealth());
					sender.sendMessage(GOLD + "[\\] " + GREEN + "Experience: "
							+ GRAY + p.getExp());
				}
				return true;
			}
		}
		
		// ytor
		if (cmd.getName().equalsIgnoreCase("ytorgonak")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.BLUE + "---- " + ChatColor.GRAY
						+ "ytorgonakPlugin 2.0" + ChatColor.BLUE + " ----");
				sender.sendMessage(WW
						+ ChatColor.GRAY
						+ " This is the menu for the ytorgonak plugin - Version 2.0");
				sender.sendMessage(WW + ChatColor.GRAY
						+ " /ytor id - Let ytorgonak identify your item");
				sender.sendMessage(WW + ChatColor.GRAY
						+ " /ytor loc - Let ytorgonak give you your location");
				return true;
			}
			if (args.length == 1) {
				// Must be a player beyond this point
				if (!(sender instanceof Player)) {
					sender.sendMessage(ArcaneCommons.noConsoleMsg());
					return true;
				}
				Player p = (Player)sender;
				
				if (args[0].equalsIgnoreCase("id")) {
					ItemStack item = p.getInventory().getItemInMainHand();
					sender.sendMessage(YT + "That's a(n) "
							+ item.getType() + " - "
							+ item.getAmount() + " of 'em!");
				} else if (args[0].equalsIgnoreCase("loc")) {
					int x = p.getLocation().getBlockX();
					int y = p.getLocation().getBlockY();
					int z = p.getLocation().getBlockZ();

					sender.sendMessage(YT + "Hey! You're located at " + x + "x, "
							+ y + "y, " + z + "z!");
				}
				return true;
			}
		}
		
		// TODO: Fix up this code by optimizing it.  This is extremely inefficient as it's written now.
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
		
		// bby
		if (cmd.getName().equalsIgnoreCase("bbycake")) {
			if (sender.hasPermission("arcane.bbycake")) {
				sender.sendMessage("You are bbycake.");
			} else {
				sender.sendMessage("You are not bbycake.");
			}
			return true;
		}
		return false;
	}
	
	public final class DonorEvents implements Listener {
		@EventHandler (priority=EventPriority.NORMAL)
		public void donorJoin(PlayerJoinEvent e) {
			if (e.getPlayer().hasPermission("arcane.donor")) {
				Player p = e.getPlayer();
				p.sendMessage(ChatColor.DARK_AQUA + " You are a donor. " + ChatColor.GRAY + getRandomDonorMessage());
				p.sendMessage("");
			}
		}
	}

	
	// To be moved to new class along with cleanup updates
	private static final String getRandomDonorMessage() {
		Random rand = new Random();
		return DONOR[rand.nextInt(DONOR.length)];
	}
	
	private static final String[] DONOR = {
		"You're pretty awesome. Seriously.",
		"You're pretty awesome. Seriously. 100% awesome.",
		"By donating, you've helped make Arcane possible. " + ChatColor.BOLD + "Thanks!",
		"Welcome back to Arcane.",
		"You're way cooler than everybody else.",
		"Thank you for your support!",
		"You should make use of your powerful /slap command.",
		"Thank you!",
		"Thank you for supporting Arcane!",
		"Don't forget, you have access to /slap. Use it wisely.",
		"You can hide yourself from the Dynmap via /dynmap hide.",
		"Did you know there's a donor only section on the forums?",
		"Welcome back to Arcane Survival!",
		"We love you.",
		"We love you. A lot.",
		"Tip: To reappear from the Dynmap if you've hidden yourself, type /dynmap show.",
		"Thank you.",
		"If you'd like to hide yourself from our Dynmap, type /dynmap hide.",
		"Did we tell you you're awesome? You really are.",
		"You're pretty awesome. Not as awesome as Agentred100 is, though.", // <.<
		"You're pretty awesome. Almost as awesome as _NickV, keep it up.",  // >.>
		"Thank you. You're awesome.",
		"Welcome back to Arcane Survival.",
		"You're a pretty cool person.",
		"What cool stuff can we give to our donors? Let us know on the forums.",
		"We appreciate your support.",
		"If you're looking for some building ideas, you can type /dclem.",
		"We appreciate your support.",
	};}
