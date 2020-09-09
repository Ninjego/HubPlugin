package me.ninjego.Hub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.ninjego.Hub.events.CompassEvent;
import me.ninjego.Hub.events.FirstItemEvent;
import me.ninjego.Hub.events.JoinLeaveEvent;
import me.ninjego.Hub.events.PlayersVisibleEvent;
import me.ninjego.Hub.events.AntiEvents.AntiBreak;
import me.ninjego.Hub.events.AntiEvents.AntiDamage;
import me.ninjego.Hub.events.AntiEvents.AntiDrop;
import me.ninjego.Hub.events.AntiEvents.AntiHunger;
import me.ninjego.Hub.events.AntiEvents.AntiInventory;
import me.ninjego.Hub.events.AntiEvents.AntiPickup;
import me.ninjego.Hub.events.AntiEvents.AntiPlace;
import me.ninjego.Hub.events.AntiEvents.AntiTarget;
import me.ninjego.Hub.utils.Items;
import me.ninjego.Hub.utils.User;

public class Main extends JavaPlugin {

	public static String Tag = "§b§l< §5§lVaderHub §b§l> §f";
	
	public static HashMap <String, Long> VisiblityCooldown = new HashMap<String, Long>();
	public static HashMap <String, Long> CompassCooldown = new HashMap<String, Long>();
	public static HashMap <String, Long> InformationCooldown = new HashMap<String, Long>();
	
	public static HashMap <Player,Long> loginTime = new HashMap<Player,Long>();
	
	public static HashMap<UUID, User> USERS = new HashMap<UUID, User>();
	public static HashMap<Boolean, Player> Visiblity = new HashMap<Boolean, Player>();
	public static List<Player> PlayersVisiblity = new ArrayList<Player>();

	public void onEnable() {
		RegisterEvents();
		new InventoryCreate().CreateGUI();
		new InventoryCreate().CreateInformation();
		InventoryAddItems();
		
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	for(Player plr : Bukkit.getOnlinePlayers()) {
            		ScoreboardManagement scor = new ScoreboardManagement(plr);
            		scor.ScoreUpdate(plr);
            	}
            }
        }, 60, 60);
	}

	public void onDisable() {

	}

	public void RegisterEvents() {
		this.getServer().getPluginManager().registerEvents(new AntiDrop(), this);
		this.getServer().getPluginManager().registerEvents(new AntiPickup(), this);
		this.getServer().getPluginManager().registerEvents(new AntiInventory(), this);
		this.getServer().getPluginManager().registerEvents(new AntiDamage(), this);
		this.getServer().getPluginManager().registerEvents(new AntiHunger(), this);
		this.getServer().getPluginManager().registerEvents(new AntiBreak(), this);
		this.getServer().getPluginManager().registerEvents(new AntiPlace(), this);
		this.getServer().getPluginManager().registerEvents(new AntiTarget(), this);

		this.getServer().getPluginManager().registerEvents(new JoinLeaveEvent(), this);
		this.getServer().getPluginManager().registerEvents(new FirstItemEvent(), this);
		this.getServer().getPluginManager().registerEvents(new CompassEvent(), this);
		this.getServer().getPluginManager().registerEvents(new PlayersVisibleEvent(), this);
	}

	public void InventoryAddItems() {
		List<String> Lore = new ArrayList<String>();
		Lore.add("");

		InventoryCreate.GUI.setItem(0, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(1, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(2, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(3, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(4, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(5, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(6, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(7, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(8, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(9, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(10, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(11, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(12, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(13, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(14, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(15, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(16, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(17, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(18, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(19, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(20, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(21, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(22, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(23, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(24, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(25, Items.Pane(Lore));
		InventoryCreate.GUI.setItem(26, Items.Pane(Lore));

		Lore.add("§7Click to enter Factions");
		Lore.add("");

		InventoryCreate.GUI.setItem(13, Items.items(Material.DIAMOND_SWORD, "§c§lFactions", Lore));
	}
}
