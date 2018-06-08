package server.SnowyCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;
import server.SnowyCore.Utils.Config;

public class CommandSpawn implements CommandExecutor {

	Main plugin;
	
	public CommandSpawn(Main pl) {
		this.plugin = pl;
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("spawn")) {
			Player p = (Player) s;
			double x;
			double y;
			double z;
			float yaw;
			float pitch;
			Config WConfig = plugin.worldconfig;
			String world = WConfig.getConfig().getString("world.spawn.world");
			World w = Bukkit.getWorld(world);
			x = WConfig.getConfig().getDouble("world.spawn.x");
			y = WConfig.getConfig().getDouble("world.spawn.y");
			z = WConfig.getConfig().getDouble("world.spawn.z");
			yaw = (float) WConfig.getConfig().getDouble("world.spawn.yaw");
			pitch = (float) WConfig.getConfig().getDouble("world.spawn.pitch");
			Location loc = new Location(w, x, y, z, yaw, pitch);
			p.teleport(loc);
			p.sendMessage(ChatColor.RED + "You have been teleported to spawn!");

		}
		
		
		return true;
	}

}
