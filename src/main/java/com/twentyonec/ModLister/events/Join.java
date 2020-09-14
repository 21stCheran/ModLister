package com.twentyonec.ModLister.events;

import java.util.List;
import java.util.Map;

import com.twentyonec.ModLister.ModLister;
import com.twentyonec.ModLister.Modes.Mode;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Join implements Listener {
	
	ModLister plugin = ModLister.getPlugin();

	@EventHandler
	public void onJoin(ServerConnectedEvent event) {
		
		Map<String, String> playerMods = event.getPlayer().getModList();
		List<String> configMods = plugin.getConfig().getModList();
		ProxiedPlayer player = event.getPlayer();
		
		Mode mode = plugin.getConfig().getMode();
		mode.playerJoins(playerMods, configMods, player);
		
	}
}
