package com.twentyonec.ModLister.Modes;

import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Whitelist implements Mode {

	@Override
	public void playerJoins(Map<String, String> playerMods, List<String>configMods,
							ProxiedPlayer player) {
		
		playerMods.forEach((key, value) -> {
			if (!configMods.contains(key)) {
				player.disconnect(new TextComponent("You have an unwhitelisted mod called "
													+ key
													+ "version: "
													+ value));
			}
		});
	}
}
