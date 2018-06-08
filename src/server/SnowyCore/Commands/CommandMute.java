package server.SnowyCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMute implements CommandExecutor {
	
	
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if(l.equalsIgnoreCase("mute")) {
			if(s.hasPermission("mute")) {
				Player target = Bukkit.getPlayer(args[0]);
				
			}
		}
		
		
		return true;
	}

}
