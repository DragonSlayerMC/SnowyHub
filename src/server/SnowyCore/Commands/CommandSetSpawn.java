package server.SnowyCore.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;

public class CommandSetSpawn implements CommandExecutor {
	
	Main plugin;
	
	public CommandSetSpawn(Main pl) {
		this.plugin = pl;
		
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("setspawn") && s.hasPermission("setspawn")) {
			Player p = (Player) s;
			plugin.worldconfig.getConfig().set("world.spawn.world", p.getLocation().getWorld().getName());
			plugin.worldconfig.getConfig().set("world.spawn.x", p.getLocation().getX());
			plugin.worldconfig.getConfig().set("world.spawn.y", p.getLocation().getY());
			plugin.worldconfig.getConfig().set("world.spawn.z", p.getLocation().getZ());
			plugin.worldconfig.getConfig().set("world.spawn.yaw", p.getLocation().getYaw());
			plugin.worldconfig.getConfig().set("world.spawn.pitch", p.getLocation().getPitch());
			p.sendMessage(plugin.prefix + ChatColor.GREEN + "The spawn has been set to your current location!");
			plugin.worldconfig.saveConfig();
		} else if(!(s.hasPermission("setspawn"))) {
			s.sendMessage(plugin.prefix + ChatColor.RED + "No permission");
		} 
		
		
		return true;
	}
	
	
	
	
}
