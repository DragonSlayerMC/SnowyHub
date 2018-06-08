package server.SnowyCore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;
import server.SnowyCore.Utils.Config;

public class onLogin implements Listener {
	
	Main plugin;
	
	public onLogin(Main pl) {
		this.plugin = pl;
	}
	
	@EventHandler
	public void LoginEvent(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		Config players = new Config(plugin, "/playerdata/" + p.getUniqueId() + ".yml");
		if(players.getConfig().get("player.isBanned") != null) {
			
			if(players.getConfig().getBoolean("player.isBanned")) {
				String reason = players.getConfig().getString("ban.banreason");
				e.setKickMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have been banned for &b" + reason + "&c by &b" + players.getConfig().getString("ban.who")));
				e.setResult(Result.KICK_BANNED);
				
				
				
			}
		}
		
		
	}
	
	

}
