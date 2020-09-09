package me.ninjego.Hub;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryCreate {

	public static Inventory GUI;
	public static Inventory InformationGUI;

	public Inventory CreateGUI() {

		GUI = Bukkit.createInventory(null, 27, "Select Server");

		return GUI;
	}
	
	public Inventory CreateInformation() {

		InformationGUI = Bukkit.createInventory(null, 9, "Information");

		return InformationGUI;
	}

}
