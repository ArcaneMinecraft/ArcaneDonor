package com.arcaneminecraft.donor;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.arcaneminecraft.api.ArcaneCommons;
import com.arcaneminecraft.api.ColorPalette;

public class ArcaneDonor extends JavaPlugin {
	private static final String DONORHELP[][] = {
			{"bbycake","(bbycake command)","Alias:\n /bby"},
			{"dclem","(DClem command)"},
			{"monreflexion","(MonReflexion command)","Alias:\n /mon\n /monr"},
			{"sharpshootingace","(SharpShootingAce command)","Alias:\n /sharp"},
			{"simonorj","(SimonOrJ command)","Alias:\n /simon"},
			{"ytorgonak","(Ytorgonak command)","Alias:\n /ytor"}
	};
	
	@Override
	public void onEnable() {
		SimpleCommands simple = new SimpleCommands();
		DClem dclem = new DClem();
		MonReflexion monr = new MonReflexion();
		SharpshootingAce sharp = new SharpshootingAce();
		Ytorgonak ytor = new Ytorgonak();
		
		getCommand("bbycake").setExecutor(simple);
		getCommand("dclem").setExecutor(dclem);
		getCommand("monreflexion").setExecutor(monr);
		getCommand("sharpshootingace").setExecutor(sharp);
		getCommand("simonorj").setExecutor(simple);
		getCommand("ytorgonak").setExecutor(ytor);
		
		getServer().getPluginManager().registerEvents(new DonorEvents(), this);
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("donor")) {
			String[] footerData = {"For more help","run /help","/help"};
			return ArcaneCommons.sendCommandMenu(sender, "Donor Command Menu", DONORHELP, footerData);
		}
		
		// Slap
		if (cmd.getName().equalsIgnoreCase("slap")) {
			// slap command permission required
			if (!sender.hasPermission("arcane.command.slap")) {
				sender.sendMessage(ArcaneCommons.tag("Slap", "Only donors can slap people!"));
				return true;
			}
			
			if (args.length == 0) {
				sender.sendMessage(ArcaneCommons.tag("Slap","Usage: /slap <player>"));
			} else {
				Player target = getServer().getPlayerExact((String) args[0]);
				if (target == null) {
					sender.sendMessage(ArcaneCommons.tag("Slap","\"" + args[0] + "\" is not online!"));
				} else {
					getServer().broadcastMessage(ColorPalette.META + sender.getName() + " slapped " + target.getName() + " in the face!");
				}
			}
		}
		return false;
	}
	
	public final class DonorEvents implements Listener {
		@EventHandler (priority=EventPriority.NORMAL)
		public void donorJoin(PlayerJoinEvent e) {
			if (e.getPlayer().hasPermission("arcane.donor")) {
				Player p = e.getPlayer();
				p.sendMessage(ColorPalette.DONOR + " You are a donor. " + ColorPalette.CONTENT + getRandomDonorMessage());
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
		//"You're pretty awesome. Not as awesome as Agentred100 is, though.", // <.<
		//"You're pretty awesome. Almost as awesome as _NickV, keep it up.",  // >.>
		"Thank you. You're awesome.",
		"Welcome back to Arcane Survival.",
		"You're a pretty cool person.",
		"What cool stuff can we give to our donors? Let us know on the forums.",
		"We appreciate your support.",
		"If you're looking for some building ideas, you can type /dclem.",
		"We appreciate your support.",
	};}
