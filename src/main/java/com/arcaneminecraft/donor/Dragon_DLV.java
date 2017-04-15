package com.arcaneminecraft.donor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Dragon_DLV implements CommandExecutor, Listener {
	private final ArcaneDonor plugin;
	//private EntityDamageEvent lastDeathDamage = null;
	private String lastDeathMsg = null; 
	
	Dragon_DLV (ArcaneDonor plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		/*
		DamageCause dc = lastDeathDamage.getCause();
		switch (lastDeathDamage.getCause()) {
		case BLOCK_EXPLOSION:
			break;
		case CONTACT:
			break;
		case CRAMMING:
			break;
		case CUSTOM:
			break;
		case DRAGON_BREATH:
			break;
		case DROWNING:
			break;
		case ENTITY_ATTACK:
			// involves another party
			break;
		case ENTITY_EXPLOSION:
			// creepers and tnt
			break;
		case ENTITY_SWEEP_ATTACK:
			break;
		case FALL:
			break;
		case FALLING_BLOCK:
			// anvils
			break;
		case FIRE:
			// exposure
			break;
		case FIRE_TICK:
			break;
		case FLY_INTO_WALL:
			break;
		case HOT_FLOOR:
			break;
		case LAVA:
			break;
		case LIGHTNING:
			break;
		case MAGIC:
			break;
		case POISON:
			break;
		case PROJECTILE:
			break;
		case STARVATION:
			break;
		case SUFFOCATION:
			break;
		case SUICIDE:
			break;
		case THORNS:
			break;
		case VOID:
			break;
		case WITHER:
			break;
		default:
		}
		*/
		return false;
	}
	
    @EventHandler (priority=EventPriority.MONITOR)
    public void onPlayerQuit(PlayerDeathEvent e) {
    	if (e.getEntity().getName() != "Dragon_DLV") return; // TODO: Use UUID
    	
    	Player p = e.getEntity();
    	lastDeathMsg = e.getDeathMessage();
    	//lastDeathDamage = p.getLastDamageCause();
    }
}
