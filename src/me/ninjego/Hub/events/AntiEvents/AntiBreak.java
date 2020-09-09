package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class AntiBreak implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player plr = (Player) e.getPlayer();

		if (!plr.hasPermission("vaderhub.admin.break")) {
			e.setCancelled(true);
		}
	}

}
