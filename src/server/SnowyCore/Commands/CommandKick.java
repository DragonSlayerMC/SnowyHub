package server.SnowyCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;
import server.SnowyCore.Utils.Utils;

public class CommandKick implements CommandExecutor {

	Main plugin;
	
	public CommandKick(Main pl) {
		this.plugin = pl;
	}


	

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("kick")) {
			if(s.hasPermission("kick")) {
				if(args.length >= 2) {
					Player pl = Bukkit.getPlayer(args[0]);
					Player p = (Player) s;
					if(pl == null) {
						s.sendMessage(plugin.prefix + ChatColor.RED + "Player not online!");
						return true;
					} else {
				if(s.hasPermission("kick.exempt")) {
					s.sendMessage(plugin.prefix + ChatColor.RED + "This player cannot be kicked!");
					return true;
					
				} else {
					String kick = plugin.prefix + ChatColor.RED + "You have been kicked by " + ChatColor.AQUA + p.getName() + ChatColor.RED + " for " + ChatColor.AQUA;
					String msg = "";
					for(int i=1; i < args.length; i++) {
						msg += args[i] + " ";
					}
					pl.kickPlayer(kick + msg);
					Utils.msgOps(plugin.prefix + ChatColor.translateAlternateColorCodes('&', "&b" + p.getName() + "&c has kicked &b" + pl.getName() + "&c for &b" + msg));
					
					
				}
					}
				} else {
					s.sendMessage(plugin.prefix + ChatColor.RED + "Usage: /kick <player> <reason>");
				}
			} else {
				s.sendMessage(plugin.prefix + ChatColor.RED + "No permission!");
			}
			
		}
		
		
		return true;
	}




}
