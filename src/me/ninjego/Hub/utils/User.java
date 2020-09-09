package me.ninjego.Hub.utils;

import org.bukkit.entity.Player;

public class User {

	public Player player;

	public User(Player player) {
		this.player = player;
	}

	public Player getUser() {
		return player;
	}

}
