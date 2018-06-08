package server.SnowyCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;

public class CommandClearChat implements CommandExecutor {

	Main plugin;
	
	public CommandClearChat(Main pl) {
		this.plugin = pl;
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("CC") || l.equalsIgnoreCase("clearchat")) {
			if(s.hasPermission("clearchat")) {
				for(int i=0; i < 100; i++) {
				Bukkit.getServer().broadcastMessage("");
				}
				Bukkit.getServer().broadcastMessage(plugin.prefix + ChatColor.GREEN + "Chat has been cleared by " + s.getName());
				
			}
		}
		
		return true;
	}

}
