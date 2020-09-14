package com.twentyonec.ModLister.events;

import java.util.Map;

import com.twentyonec.ModLister.ModLister;
import com.twentyonec.ModLister.Modes.Mode;

import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Join implements Listener {
	
	ModLister plugin = ModLister.getPlugin();

	@EventHandler
	public void onJoin(ServerConnectedEvent event) {
		
		Map<String, String> mods = event.getPlayer().getModList();
		Mode mode = plugin.getConfig().getMode();
		mode.playerJoins(mods);
		
		event.getPlayer().getModList().forEach((key, value) -> {
			System.out.println("Key: " + key);
			System.out.println("Value: " + value);
		});
		
	}
}
