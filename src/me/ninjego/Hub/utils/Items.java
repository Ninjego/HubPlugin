package me.ninjego.Hub.utils;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

	public static ItemStack items(Material mat, String DisplayName, List<String> Lores) {

		ItemStack item = new ItemStack(mat);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(DisplayName);

		meta.setLore(Lores);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack Pane(List<String> Lores) {

		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName("§l");

		meta.setLore(Lores);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		item.setItemMeta(meta);

		return item;
	}

}
