package com.twentyonec.ModLister.Modes;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.twentyonec.ModLister.ModLister;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Blacklist implements Mode {

	ModLister plugin = ModLister.getPlugin();
	
	@Override
	public void playerJoins(Map<String, String> playerMods, List<String>configMods,
							ProxiedPlayer player) {
		
		plugin.getProxy().getScheduler().schedule(plugin, new Runnable() {
			@Override
            public void run() {
            	configMods.forEach((key) -> {
					if (playerMods.containsKey(key)) {
						player.disconnect(new TextComponent("You contain a blacklisted mod called "
															+ key));
					}
				});
            }
         }, 1, TimeUnit.SECONDS);
	}
}
