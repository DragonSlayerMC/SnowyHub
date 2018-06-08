package server.SnowyCore.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
	
	public static void msgOps(String message) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.hasPermission("notify")) {
				p.sendMessage(message);
			}
		}
	}
	
	

}
