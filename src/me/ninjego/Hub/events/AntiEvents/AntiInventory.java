package me.ninjego.Hub.events.AntiEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.ninjego.Hub.InventoryCreate;

public class AntiInventory implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player plr = (Player) e.getWhoClicked();
		if (e.getInventory().equals(InventoryCreate.GUI)) {
			e.setCancelled(true);

			try {
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Factions")) {
				plr.chat("/server factions");
				plr.closeInventory();
			}				
			} catch(Exception es) { }

		} else if (!e.getWhoClicked().hasPermission("vaderhub.admin.clickinventory"))
			e.setCancelled(true);

	}

}
