package server.SnowyCore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import server.SnowyCore.Main.Main;
import server.SnowyCore.Utils.Config;

public class onJoin implements Listener {

	Main plugin;
	
	public onJoin(Main pl) {
		this.plugin = pl;
	}
	
	@EventHandler
	public void JoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Config players = new Config(plugin, "/playerdata/" + p.getUniqueId() + ".yml");
		if(players.getConfig().get("player.isBanned") != null) {
			return;
		} else {
			
			
			players.getConfig().set("player.isBanned", false);
			players.getConfig().set("player.isMuted", false);
			players.getConfig().set("player.isTempbanned", false);
			players.getConfig().set("player.isOwner", false);
			players.getConfig().set("player.group", "Member");
			players.saveConfig();
			
		}
		
		
	}
	
	
}
