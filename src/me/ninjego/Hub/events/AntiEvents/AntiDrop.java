package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class AntiDrop implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (!e.getPlayer().hasPermission("vaderhub.admin.drop")) {
			e.setCancelled(true);
		}
	}

}
