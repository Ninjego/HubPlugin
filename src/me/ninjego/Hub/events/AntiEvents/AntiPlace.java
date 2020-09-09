package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiPlace implements Listener {

	@EventHandler
	public void onBreak(BlockPlaceEvent e) {
		Player plr = (Player) e.getPlayer();

		if (!plr.hasPermission("vaderhub.admin.place")) {
			e.setCancelled(true);
		}
	}

}
