package server.SnowyCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;
import server.SnowyCore.Utils.Config;

public class CommandUnban implements CommandExecutor {
	
	Main plugin;
	
	public CommandUnban(Main pl) {
		this.plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("unban")) {
			if(s.hasPermission("unban")) {
				if(args.length == 1) {
					Player pl = (Player) s;
					Player p = Bukkit.getPlayer(args[0]);
					if(p != null) {
						Config player = new Config(plugin, "/playerdata/" + p.getUniqueId() + ".yml");
						player.getConfig().set("player.isBanned", false);
						player.saveConfig();
						s.sendMessage(plugin.prefix + ChatColor.AQUA + "Player unbanned");
					} else {
						OfflinePlayer op = (OfflinePlayer) Bukkit.getOfflinePlayer(args[0]);
						Config player = new Config(plugin, "/playerdata/" + op.getUniqueId() + ".yml");
						player.getConfig().set("player.isBanned", false);
						player.saveConfig();
						s.sendMessage(plugin.prefix + ChatColor.AQUA + "Player unbanned");
						
					}
					
					
					
				}
				
				
			}
		}
		
		
		
		return true;
	}
	
	

}
