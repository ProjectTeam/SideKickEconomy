package com.emericask8ur.SideKickEconomy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Permission {
	
	/**
	 * Checks and returns if a player has permission to use a node.</br>
	 *  If not, the player will return a message "You do not have permission".
	 * @param player
	 * @param node
	 * @return
	 */
	public static boolean hasNode(Player player, String node){
		if(player.hasPermission("SideKickEconomy." + node)){
			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission!");
			return false;
		}
	}
	
	/**
	 * Checks and returns if a player has permission to use a node.</br>
	 * If not, the player will return a message "You do not have permission".
	 * @param player
	 * @param node
	 * @return
	 */
	public static boolean hasPermission(Player player, String node){
		if(player.hasPermission(node)){
			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission");
			return false;
		}
	}

}
