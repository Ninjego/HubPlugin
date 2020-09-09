package me.ninjego.Hub.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjego.Hub.InventoryCreate;
import me.ninjego.Hub.Main;

public class CompassEvent implements Listener {

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player plr = (Player) e.getPlayer();

		if (plr.getInventory().getItemInHand() == null)
			return;
		if (plr.getInventory().getItemInHand().getType() == Material.COMPASS)
			if (plr.getInventory().getItemInHand().getItemMeta().hasLore()) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					
					if(!plr.hasPermission("vaderhub.admin.cooldown"))
					if(Main.CompassCooldown.containsKey(plr.getName())) {
						if(Main.CompassCooldown.get(plr.getName()) > System.currentTimeMillis()) {
							long timeleft = (Main.CompassCooldown.get(plr.getName()) - System.currentTimeMillis()) / 1000;
							plr.sendMessage(Main.Tag + ChatColor.RED + "You have to wait §e" + timeleft + "s §cto do this");
							return;
						}
					}

					Main.CompassCooldown.put(plr.getName(), System.currentTimeMillis() + (3 * 1000));
					
					plr.openInventory(InventoryCreate.GUI);
				}
			}
	}

}
