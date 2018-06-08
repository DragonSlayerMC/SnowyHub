package server.SnowyCore.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import server.SnowyCore.Main.Main;

public class CommandWarps implements CommandExecutor {
	
	Main plugin;
	
	public CommandWarps(Main pl) {
		this.plugin = pl;
	}	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		List<String> warps = plugin.getWConfig().getConfig().getStringList("warps.warps");
		if(warps == null) {
			p.sendMessage(plugin.prefix + ChatColor.RED + "No warps");
			return true;
		} else {
		String warpStr = "";
		for(String str : warps)
			warpStr += str + ", ";
		
		p.sendMessage(plugin.prefix + "Warps: " + warpStr);
		return true;
		}
	}
	
	
}
