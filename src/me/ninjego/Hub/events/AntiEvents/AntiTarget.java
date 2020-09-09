package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class AntiTarget implements Listener {

	@EventHandler
	public void NoTarget(EntityTargetEvent event) {
		event.setCancelled(true);
	}

}
