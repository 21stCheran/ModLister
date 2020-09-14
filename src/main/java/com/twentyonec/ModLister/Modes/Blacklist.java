package com.twentyonec.ModLister.Modes;

import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Blacklist implements Mode {

	@Override
	public void playerJoins(Map<String, String> playerMods, List<String>configMods,
							ProxiedPlayer player) {
		
		configMods.forEach((key) -> {
			if (playerMods.containsKey(key)) {
				player.disconnect(new TextComponent("You contain a blacklisted mod called"
													+ key));
			}
		});
	}
}
