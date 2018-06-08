package server.SnowyCore.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import server.SnowyCore.Commands.*;
import server.SnowyCore.Events.*;
import server.SnowyCore.Utils.*;

public class Main extends JavaPlugin {
	
	Main plugin;
	
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	//Configs
	public Config worldconfig;
	public Config punishmentsconfig;
	
	
	public String prefix = ChatColor.translateAlternateColorCodes('&', "&0[&bSnowy&0] &c");
	
	public boolean ChatMuted = false;
	
	
	public void onEnable() {
		plugin = this;
		worldconfig = new Config(this, "locations.yml");
		punishmentsconfig = new Config(this, "punishments.yml");
		
		
		pm.registerEvents(new onJoin(this), this);
		pm.registerEvents(new onLogin(this), this);
		
		
		this.getCommand("ban").setExecutor(new CommandBan(this));
		this.getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
		this.getCommand("spawn").setExecutor(new CommandSpawn(this));
		this.getCommand("warps").setExecutor(new CommandWarps(this));
		this.getCommand("warp").setExecutor(new CommandWarp(this));
		this.getCommand("setwarp").setExecutor(new CommandSetWarp(this));
		this.getCommand("cc").setExecutor(new CommandClearChat(this));
		this.getCommand("clearchat").setExecutor(new CommandClearChat(this));
		this.getCommand("unban").setExecutor(new CommandUnban(this));
		this.getCommand("kick").setExecutor(new CommandKick(this));
		
	}
	
	
	
	
	public void onDisable() {
		
		
		
		
		
		
	}
	
	
	public Config getWConfig() {
		return worldconfig;
	}
	
	
	


}
