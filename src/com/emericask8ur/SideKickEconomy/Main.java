package com.emericask8ur.SideKickEconomy;

import java.io.File;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;




public class Main extends JavaPlugin{
	public FileConfiguration config;
	public String configString;
	public FileConfiguration BlackList;
	public static String plugindir = "plugins/SideKickEconomy/";
	public static File cfg = new File(plugindir + "SideKickEconomy.yml");
	public static Plugin plugin;
	

	@Override
	public void onDisable() {
		saveConfig();
	}

	@Override 
	public void onEnable() {
		plugin = this;
		this.getServer().getPluginManager().registerEvents(new Events(), this);
		loadConfig();
	}
	
	public void loadConfig() {
		config = this.getConfig();
		ConfigurationSection section = config.getConfigurationSection("money");
		if (section != null) {
			for (String key : section.getKeys(false)) {
				double money = section.getDouble(key, section.getInt(key, 0));
				Economy.economy.put(key, money);
			}
		}
	}
	
	public void saveConfig() {
		config = this.getConfig();
				for (Map.Entry<String, Double> entry : Economy.economy.entrySet()) {
			config.set("money." + entry.getKey(), entry.getValue());
		}
		super.saveConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		Player player = (Player)sender;
		ChatColor g = ChatColor.GREEN;
		ChatColor a = ChatColor.GRAY;
		double getMoney = Economy.getMoney(player.getName());
		if(cmdLabel.equalsIgnoreCase("economy")){
		 Menu.EcoMenu1(sender);
		 return true;
		}
		else if (cmdLabel.equalsIgnoreCase("s")){
				if(args.length==1){
				if(args[0].equalsIgnoreCase("money") && Permission.hasNode(player, "balance")){
					player.sendMessage(a + "Balance: " + g + "$" + getMoney);
					return true;
				}
				return true;
			}
			else if (args.length==3){
				if(args[0].equalsIgnoreCase("pay") && Permission.hasNode(player, "pay")){
						Player p = this.getServer().getPlayer(args[1]);
						if(p == null){
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
						try{
							
						double x = Double.parseDouble(args[2]);
						if(Economy.getMoney(player.getName()) <=0  || Economy.getMoney(player.getName()) <= x){
							sender.sendMessage(ChatColor.RED + "You cannot pay! You do not have enough money!");
						} else {
							Economy.addMoney(p.getName(), x);
							Economy.subtractMoney(player.getName(), x);
							sender.sendMessage(a + "You paid: " + ChatColor.YELLOW + p.getName() + g + " $" + x);
							p.sendMessage(a + "You have received " + g + "$" + x + a + " from: " + ChatColor.YELLOW + sender.getName());
					}
						}catch (Exception i){
							
						}
				}
				else if (args[0].equalsIgnoreCase("give") && Permission.hasNode(player, "give")){
						Player p = this.getServer().getPlayer(args[1]);
						if(p == null){
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
						try{
							double x = Double.parseDouble(args[2]);
							Economy.addMoney(p.getName(), x);
							sender.sendMessage(a + "You gave " + g + "$" + x + a + " to " + ChatColor.YELLOW + p.getName());
						}catch (Exception i){
							
						}
				}
				else if (args[0].equalsIgnoreCase("set") && Permission.hasNode(player, "set")){
						Player p = this.getServer().getPlayer(args[1]);
						if(p == null){
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
						try{
							double x = Double.parseDouble(args[2]);
							Economy.setMoney(p.getName(), x);
							sender.sendMessage(a + "You set " + ChatColor.YELLOW + p.getName() + g + "'s money to " + g + "$" + x);
						}catch (Exception i){
							
						}
				}
				else if (args[0].equalsIgnoreCase("take") && Permission.hasNode(player, "take")){
						Player p = this.getServer().getPlayer(args[1]);
						if(p == null){
							sender.sendMessage(ChatColor.RED + "Player not found!");
						}
						try{
							double x = Double.parseDouble(args[2]);
							Economy.subtractMoney(p.getName(), x);
							sender.sendMessage(a + "You took " + g + "$" + x + g + " from " + ChatColor.YELLOW + p.getName());
						}catch (Exception i){
							
						}
				} else {
					sender.sendMessage(ChatColor.RED + "Check your arguments");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Check your arguments!");
			}
		}
		return true; 
		
	}
}
