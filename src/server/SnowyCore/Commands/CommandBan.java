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

public class CommandBan implements CommandExecutor {

	Main plugin;
	
	public CommandBan(Main pl) {
		this.plugin = pl;
	}
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("ban")) {
			if(s.hasPermission("ban")) {
				Player p = (Player) s;
				if(args.length >= 2) {
					Player pl = Bukkit.getPlayer(args[0]);
					if(pl != null && !(args[0].equalsIgnoreCase("Teleports")) && !(args[0].equalsIgnoreCase("Caloriee"))) {
						Config players = new Config(plugin, "/playerdata/" + pl.getUniqueId() + ".yml");
						players.getConfig().set("player.isBanned", true);
						String msg = "";
						for(int i=1; i < args.length; i++) {
							msg += args[i] + " ";
						}
						
						players.getConfig().set("ban.banreason", msg);
						players.getConfig().set("ban.who", p.getName());
						players.saveConfig();
						pl.kickPlayer(plugin.prefix + ChatColor.translateAlternateColorCodes('&', "&cYou have been banned by &b" + p.getName() + " &cfor &b" + msg));
						
						for(Player ops : Bukkit.getOnlinePlayers()) {
							if(ops.hasPermission("member")) {
								ops.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer &b" + args[0] + " &chas been banned by &b " + p.getName() + " &cfor &b" + msg));
							}
						}
						
					} else if(!(args[0].equalsIgnoreCase("Teleports")) && !(args[0].equalsIgnoreCase("Caloriee"))){
						OfflinePlayer pla = Bukkit.getOfflinePlayer(args[0]);
						Config players = new Config(plugin, "/playerdata/" + pla.getUniqueId() + ".yml");
						players.getConfig().set("player.isBanned", true);
						String msg = "";
						for(int i=1; i < args.length; i++) {
							msg += args[i] + " ";
						}
						
						players.getConfig().set("ban.banreason", msg);
						players.getConfig().set("ban.who", p.getName());
						players.saveConfig();
						for(Player ops : Bukkit.getOnlinePlayers()) {
							if(ops.hasPermission("member")) {
								ops.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer &b" + args[0] + " &chas been banned by &b " + p.getName() + " &cfor &b" + msg));
							}
						}
						
						
					} else {
						p.sendMessage(plugin.prefix + ChatColor.RED + "This player can not be banned!");
					}
					
					
				}
				
				
			}
		}
		
		
		
		
		
		return true;
	}

}
