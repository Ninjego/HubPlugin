package me.ninjego.Hub;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardManagement {

	public Main main;
	
	public ScoreboardManagement(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		Objective obj = board.registerNewObjective("HubScoreboard", "dummy");
		obj.setDisplayName("§5§l << §d§lVader Hub§d§l >>");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		player.setScoreboard(board);

	}

	public void ScoreUpdate(Player player) {
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		Objective obj = board.registerNewObjective("HubScoreboard", "dummy");
		obj.setDisplayName("§5§l << §d§lVader Hub§d§5§l >>");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score13 = obj.getScore("§1---------------------");
		score13.setScore(13);
		Score score12 = obj.getScore("§9Factions Online:");
		score12.setScore(12);
		Score score11 = obj.getScore("§fComing soon");
		score11.setScore(11);
		Score score10 = obj.getScore("§f§d§l ");
		score10.setScore(10);	
		Score score9 = obj.getScore("§9Ping:");
		score9.setScore(9);	
		Score score8 = obj.getScore("§f" + ((CraftPlayer)player).getHandle().ping);
		score8.setScore(8);	
		Score score7 = obj.getScore("§d§l ");
		score7.setScore(7);	
		Score score6 = obj.getScore("§9Username:");
		score6.setScore(6);	
		Score score5 = obj.getScore("§f" + player.getName());
		score5.setScore(5);	
		Score score4 = obj.getScore("§l ");
		score4.setScore(4);	
		Score score3 = obj.getScore("§9Server IP:");
		score3.setScore(3);		
		Score score2 = obj.getScore("§fplay.vadermc.net");
		score2.setScore(2);		
		Score score1 = obj.getScore("§b§1---------------------");
		score1.setScore(1);
		player.setScoreboard(board);	
	}

}
