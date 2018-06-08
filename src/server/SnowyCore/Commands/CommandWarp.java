package server.SnowyCore.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;

public class CommandWarp implements CommandExecutor {
	
	Main plugin;
	
	public CommandWarp(Main pl) {
		this.plugin = pl;
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		//DELAY
		Player p = (Player) s;
		FileConfiguration config = plugin.getWConfig().getConfig();
		List<String> warps = plugin.getWConfig().getConfig().getStringList("warps.warps");
		
		p.performCommand("warps");
		
		if(args.length == 1) {
			String warp = args[0].toLowerCase();
			if(warps.contains(warp)) {
				Location loc = new Location(Bukkit.getWorld(config.getString("warps." + warp + ".world")),
						config.getDouble("warps." + warp + ".x"),
						config.getDouble("warps." + warp + ".y"),			
						config.getDouble("warps." + warp + ".z"),
						Float.parseFloat(config.getString("warps." + warp + ".pitch")),
						Float.parseFloat(config.getString("warps." + warp + ".yaw")));
				p.teleport(loc);
				p.sendMessage(plugin.prefix + "Warping to " + warp + ".");
				return true;
			}
			p.sendMessage(plugin.prefix + "Cannot find warp " + warp + ".");
		}
		
		if(args.length == 2) {
			Player target = Bukkit.getPlayer(args[1]);
			if(target == null) {
				p.sendMessage(plugin.prefix + "Cannot find " + args[1]);
				return true;
			}
			String warp = args[0].toLowerCase();
			if(warps.contains(warp)) {
				Location loc = new Location(Bukkit.getWorld(config.getString("warps." + warp + ".world")),
						config.getDouble("warps." + warp + ".x"),
						config.getDouble("warps." + warp + ".y"),			
						config.getDouble("warps." + warp + ".z"),
						Float.parseFloat(config.getString("warps." + warp + ".pitch")),
						Float.parseFloat(config.getString("warps." + warp + ".yaw")));
				target.teleport(loc);
				target.sendMessage(plugin.prefix + "Warping to " + warp + ".");
				p.sendMessage(plugin.prefix + "Warping " + target.getName() + " to " + warp + ".");
				return true;
			}
			p.sendMessage(plugin.prefix + "Cannot find warp " + warp + ".");
		}
		return true;
	}

}
