package me.ninjego.Hub.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.ninjego.Hub.Main;
import me.ninjego.Hub.utils.Items;

public class PlayersVisibleEvent implements Listener {
	
	@SuppressWarnings("unused")
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player plr = (Player) e.getPlayer();

		List<String> lore = new ArrayList<String>();

		lore.clear();

		lore.add("");
		lore.add("§7Right click to make every player visible");
		lore.add("");

		if (plr.getInventory().getItemInHand() == null)
			return;
		if (plr.getInventory().getItemInHand().getType() == Material.BLAZE_ROD) {
			if (plr.getInventory().getItemInHand().getItemMeta().hasLore()) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					
					if(!plr.hasPermission("vaderhub.admin.cooldown"))
					if(Main.VisiblityCooldown.containsKey(plr.getName())) {
						if(Main.VisiblityCooldown.get(plr.getName()) > System.currentTimeMillis()) {
							long timeleft = (Main.VisiblityCooldown.get(plr.getName()) - System.currentTimeMillis()) / 1000;
							plr.sendMessage(Main.Tag + ChatColor.RED + "You have to wait §e" + timeleft + "s §cto do this");
							return;
						}
					}
					
					for (Player pl : Bukkit.getOnlinePlayers())
						plr.hidePlayer(pl);
					
					long loginAt = Main.loginTime.get(plr);
					long diff = System.currentTimeMillis() - loginAt;
					int seconds = (int) diff / 1000;
					
					Main.VisiblityCooldown.put(plr.getName(), System.currentTimeMillis() + (3 * 1000));

					Main.PlayersVisiblity.add(plr);
					plr.getInventory().setItem(7, Items.items(Material.STICK, "§ePlayers Invisible ", lore));
				}
			}
		} else if (plr.getInventory().getItemInHand().getType() == Material.STICK) {
			if (plr.getInventory().getItemInHand().getItemMeta().hasLore()) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					
					if(!plr.hasPermission("vaderhub.admin.cooldown"))
					if(Main.VisiblityCooldown.containsKey(plr.getName())) {
						if(Main.VisiblityCooldown.get(plr.getName()) > System.currentTimeMillis()) {
							long timeleft = (Main.VisiblityCooldown.get(plr.getName()) - System.currentTimeMillis()) / 1000;
							plr.sendMessage(Main.Tag + ChatColor.RED + "You have to wait §e" + timeleft + "s §cto do this");
							return;
						}
					}
					
					for (Player pl : Bukkit.getOnlinePlayers())
						plr.showPlayer(pl);

					lore.clear();

					lore.add("");
					lore.add("§7Right click to make every player invisible");
					lore.add("");

					long loginAt = Main.loginTime.get(plr);
					long diff = System.currentTimeMillis() - loginAt;
					int seconds = (int) diff / 1000;
					
					Main.VisiblityCooldown.put(plr.getName(), System.currentTimeMillis() + (3 * 1000));
					
					Main.PlayersVisiblity.remove(plr);
					plr.getInventory().setItem(7, Items.items(Material.BLAZE_ROD, "§ePlayers Visible ", lore));
				}
			}
		}
	}
}
