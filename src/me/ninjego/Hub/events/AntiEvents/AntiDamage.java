package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class AntiDamage implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		if (!(e.getCause() == DamageCause.CUSTOM))
			e.setCancelled(true);
	}

}
