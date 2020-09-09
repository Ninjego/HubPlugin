package me.ninjego.Hub.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjego.Hub.Main;

public class FirstItemEvent implements Listener {

	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player plr = (Player) e.getPlayer();

		if (plr.getInventory().getItemInHand() == null)
			return;
		if (plr.getInventory().getItemInHand().getType() == Material.ARROW)
			if (plr.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Launcher")) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					
					if(!plr.hasPermission("vaderhub.admin.cooldown"))
					if(Main.InformationCooldown.containsKey(plr.getName())) {
						if(Main.InformationCooldown.get(plr.getName()) > System.currentTimeMillis()) {
							long timeleft = (Main.InformationCooldown.get(plr.getName()) - System.currentTimeMillis()) / 1000;
							plr.sendMessage(Main.Tag + ChatColor.RED + "You have to wait §e" + timeleft + "s §cto do this");
							return;
						}
					}

					Main.InformationCooldown.put(plr.getName(), System.currentTimeMillis() + (10 * 1000));
					
					plr.setVelocity(plr.getLocation().getDirection().multiply(3).setY(1));
				}
			}
	}
	
}
