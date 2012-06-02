package com.emericask8ur.SideKickEconomy;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class Menu {
	
	public static void EcoMenu1(CommandSender sender){
		ChatColor g = ChatColor.GREEN;
		ChatColor a = ChatColor.GRAY;
		ChatColor y = ChatColor.YELLOW;
		ChatColor x = ChatColor.DARK_RED;
			sender.sendMessage(y + "☤----" + g + "SideKickEconomy" + y + "----☤");
			sender.sendMessage(ChatColor.AQUA + "Welcome: " + x + sender.getName());
			if(sender.hasPermission("SideKickEconomy.balance")){
			sender.sendMessage(a + "/S Money - " + g + "Shows your balance");
			}
			if(sender.hasPermission("SideKickEconomy.pay")){
			sender.sendMessage(a + "/S Pay [Username] [Amount] - " + g + "Pays a user");
			}
			if(sender.hasPermission("SideKickEconomy.give")){
			sender.sendMessage(a + "/S Give [Username] [Amount] - " + g + "Gives user money");
			}
			if(sender.hasPermission("SideKickEconomy.set")){
			sender.sendMessage(a + "/S Set [Username] [Amount] - " + g + "Set user's money");
			}
			if(sender.hasPermission("SideKickEconomy.take")){
				sender.sendMessage(a + "/S Take [Username] [Amount] - " + g + "Takes amount from user");
			}
	  }
}



