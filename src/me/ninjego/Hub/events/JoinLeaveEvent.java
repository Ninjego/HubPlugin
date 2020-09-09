package me.ninjego.Hub.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;

import me.ninjego.Hub.Main;
import me.ninjego.Hub.ScoreboardManagement;
import me.ninjego.Hub.utils.Items;
import me.ninjego.Hub.utils.User;
import net.minecraft.server.v1_8_R3.TileEntitySkull;

public class JoinLeaveEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player plr = (Player) e.getPlayer();

		for (Player p : Main.PlayersVisiblity) {
			p.hidePlayer(plr);
		}
		ScoreboardManagement scorebord = new ScoreboardManagement(plr);

		for (Player ps : Bukkit.getOnlinePlayers()) {
			scorebord.ScoreUpdate(ps);
		}

		Main.loginTime.put(e.getPlayer(), System.currentTimeMillis());
		
		Main.USERS.put(plr.getUniqueId(), new User(plr));
		plr.getInventory().clear();

		List<String> lore = new ArrayList<String>();

		lore.add("");

		plr.getInventory().setItem(0, Items.Pane(lore));

		plr.getInventory().setItem(2, Items.Pane(lore));
		plr.getInventory().setItem(3, Items.Pane(lore));
		plr.getInventory().setItem(5, Items.Pane(lore));
		plr.getInventory().setItem(6, Items.Pane(lore));
		plr.getInventory().setItem(8, Items.Pane(lore));
		
		lore.add("§7Right click to get launched");
		lore.add("");
		
		
		plr.getInventory().setItem(1, Items.items(Material.ARROW, "§c§lLauncher", lore));
		
		
		double MaxHealth = plr.getMaxHealth();
		plr.setHealth(MaxHealth);

		plr.setFoodLevel(20);

		lore.clear();

		lore.add("");
		lore.add("§7Right click to make every player invisible");
		lore.add("");

		plr.getInventory().setItem(7, Items.items(Material.BLAZE_ROD, "§ePlayers Visible ", lore));
		lore.clear();

		lore.add("");
		lore.add("§7Right click to view servers");
		lore.add("");

		plr.getInventory().setItem(4, Items.items(Material.COMPASS, "§bServer Selector", lore));
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player plr = (Player) e.getPlayer();

		for (Player p : Main.PlayersVisiblity) {
			p.showPlayer(plr);
		}

		Main.PlayersVisiblity.remove(plr);

		Main.USERS.remove(plr.getUniqueId());
	}
	
	public void addSkull(String owner, Player plr) {
	    TileEntitySkull.b(new GameProfile(null, owner), gameProfile -> {
	        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	        SkullMeta meta = (SkullMeta) skull.getItemMeta();
	        meta.setDisplayName("§b§lInformation");
	        meta.setOwner(owner);
	        skull.setItemMeta(meta);
	        plr.getInventory().addItem(skull);
	        return false;
	    });
	}
}
