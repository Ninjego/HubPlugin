package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class AntiPickup implements Listener {

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (!e.getPlayer().hasPermission("vaderhub.admin.pickup"))
			e.setCancelled(true);
	}

}
