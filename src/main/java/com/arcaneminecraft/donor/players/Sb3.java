package com.arcaneminecraft.donor.players;

import com.arcaneminecraft.donor.ArcaneDonor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Sb3 implements TabExecutor, Listener {
    private static final String MOD_PERMISSION = "arcane.donor.sb3.mod";
    private static final String WORDLIST_CONFIG = "sb3.words";
    private final ArcaneDonor plugin = ArcaneDonor.getInstance();
    private final HashMap<CommandSender, String> players = new HashMap<>();
    private final List<String> words;
    private final Random random = new Random();

    private static final String ADD_CMD = "-add";
    private static final String REMOVE_CMD = "-remove";
    private static final String NEW_CMD = "-new";

    private static final ChatColor ERROR_COL = ChatColor.RED;
    private static final ChatColor SB_COL = ChatColor.BLUE;
    private static final ChatColor MOD_COL = ChatColor.GREEN;
    private static final String TAG = ChatColor.AQUA + "Sbramble" + ChatColor.DARK_GRAY + " \\|\\ " + SB_COL;

    public Sb3() {
        this.words = plugin.getConfig().getStringList(WORDLIST_CONFIG);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            if (words.isEmpty()) {
                sender.sendMessage(ERROR_COL + "There are no words in the library at the moment");
                return true;
            }
            String word = players.get(sender);
            if (word == null) {
                newWord(sender, label);
            } else {
                sendUnscrambleMessage(sender, word, label);
            }
        }

        if (args[0].equalsIgnoreCase(NEW_CMD)) {
            newWord(sender, label);
        }

        boolean add = args[0].equalsIgnoreCase(ADD_CMD);

        if (sender.hasPermission(MOD_PERMISSION) && (add || args[0].equalsIgnoreCase(REMOVE_CMD))) {
            if (args.length > 2) {
                modList(sender, args[1], add);
            } else {
                sender.sendMessage(TAG + "Please indicate a word to add or remove");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> ret = new ArrayList<>();

        if (args.length == 1) {
            if (NEW_CMD.startsWith(args[0].toLowerCase()))
                ret.add(NEW_CMD);

            if (sender.hasPermission(MOD_PERMISSION)) {
                if (ADD_CMD.startsWith(args[0].toLowerCase()))
                    ret.add(ADD_CMD);
                if (REMOVE_CMD.startsWith(args[0].toLowerCase()))
                    ret.add(REMOVE_CMD);
            }
        }

        return ret;
    }

    private void newWord(CommandSender sender, String label) {
        String word = words.get(random.nextInt(words.size()));

        players.put(sender, word);
        sendUnscrambleMessage(sender, word, label);
    }

    private void sendUnscrambleMessage(CommandSender sender, String word, String label) {
        char[] c = word.toCharArray();
        int p = 0;
        char temp = c[p];

        for (int i = 0; i < c.length; i++) {
            int n = random.nextInt(c.length);
            c[p] = c[n];
            p = n;
        }

        c[p] = temp;

        sender.sendMessage(TAG + "Unscramble: " + ChatColor.WHITE + String.valueOf(c) + '\n' + SB_COL + " Answer using '" + ChatColor.WHITE + label + " <word>" + SB_COL + "'; for new word, run '" + ChatColor.WHITE + label + " -new" + SB_COL + "'");
    }

    private void modList(CommandSender sender, String word, boolean add) {
        word = word.replaceAll("[A-Za-z]+", "");

        if (!sender.hasPermission(MOD_PERMISSION)) {
            sender.sendMessage(ERROR_COL + "You do not have permission to modify the word list!");
            return;
        }

        if (add) {
            if (words.contains(word)) {
                sender.sendMessage(ERROR_COL + "That word was already added");
            } else {
                words.add(word);
                plugin.getConfig().set(WORDLIST_CONFIG, words);
                sender.sendMessage(TAG + "Added " + word + " to the collection");
            }
        } else {
            if (words.remove(word)) {
                sender.sendMessage(TAG + "Removed " + word + " from the collection");
                plugin.getConfig().set(WORDLIST_CONFIG, words);
            } else {
                sender.sendMessage(ERROR_COL + "That word was already removed");
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        players.remove(e.getPlayer());
    }
}
