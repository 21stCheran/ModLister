package com.twentyonec.ModLister.Modes;

import java.util.List;
import java.util.Map;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public interface Mode {	
	void playerJoins(Map<String,String> playerMods,List<String>configMods,
					 ProxiedPlayer player);
}