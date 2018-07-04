package com.arcaneminecraft.donor;

import com.arcaneminecraft.api.ArcaneColor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class ArcaneDonor extends JavaPlugin {

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

            sender.sendMessage("Donor commands: /bbycake, /dclem, /monreflexion, /sharpshootingace, /simonorj, /ytorgonak");
            // TODO: Get list of all donors from LuckPerms


            return true;
        }
        return false;
    }


    // TODO: Move this into ArcaneBungee
    public final class DonorEvents implements Listener {
        private final String[] DONOR = {
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
        };

        // To be moved to new class along with cleanup updates
        private String getRandomDonorMessage() {
            Random rand = new Random();
            return DONOR[rand.nextInt(DONOR.length)];
        }

        @EventHandler(priority = EventPriority.NORMAL)
        public void donorJoin(PlayerJoinEvent e) {
            if (e.getPlayer().hasPermission("arcane.donor")) {
                Player p = e.getPlayer();
                p.sendMessage(ArcaneColor.DONOR + " You are a donor. " + ArcaneColor.CONTENT + getRandomDonorMessage());
                p.sendMessage("");
            }
        }
    }


}
