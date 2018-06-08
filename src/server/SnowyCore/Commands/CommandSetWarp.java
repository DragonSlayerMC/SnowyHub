package server.SnowyCore.Commands;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import server.SnowyCore.Main.Main;

public class CommandSetWarp implements CommandExecutor {

	Main plugin;
	
	public CommandSetWarp(Main pl) {
		this.plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		
		if(args.length == 0) {
			p.sendMessage(plugin.prefix + "Usage: /setwarp <name>");
			return true;
		}
		
		FileConfiguration config = plugin.getWConfig().getConfig();
		
		if(args.length == 1) {
			String name = args[0];
			Location loc = p.getLocation();

			config.set("warps." + name + ".world", loc.getWorld());
			config.set("warps." + name + ".x", loc.getX());
			config.set("warps." + name + ".y", loc.getY());
			config.set("warps." + name + ".z", loc.getZ());
			config.set("warps." + name + ".pitch", loc.getPitch());
			config.set("warps." + name + ".yaw", loc.getYaw());
			
			ArrayList<String> list = (ArrayList<String>) config.getStringList("warps.warps");
			if(!list.contains(name.toLowerCase())) list.add(name.toLowerCase());
			config.set("warps.warps", list);
			plugin.getWConfig().saveConfig();
			
			p.sendMessage(plugin.prefix + "Set warp " + name + " at your current position.");
			return true;
		}
		return true;
	}
	
	
	
}
