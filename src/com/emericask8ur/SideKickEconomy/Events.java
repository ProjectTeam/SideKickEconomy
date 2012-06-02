package com.emericask8ur.SideKickEconomy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class Events implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerLogin(PlayerLoginEvent event){
		if(!Economy.hasAccount(event.getPlayer().getName())){
			Economy.createDefaultAccount(event.getPlayer().getName());
		}
	}

}
