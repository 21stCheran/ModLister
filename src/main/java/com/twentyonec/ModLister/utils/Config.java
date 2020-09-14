package com.twentyonec.ModLister.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

import com.twentyonec.ModLister.ModLister;
import com.twentyonec.ModLister.Modes.Blacklist;
import com.twentyonec.ModLister.Modes.Mode;
import com.twentyonec.ModLister.Modes.Whitelist;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config {
	private ModLister plugin = ModLister.getPlugin();
	private Configuration configuration;
	private List<?> modList;
	
	private final String DEBUG_PATH = "debug";
	private final String LIST_PATH =  "modifications";
	private final String MODE_PATH = "mode";
	
	public Config() {
		saveConfig();
		loadConfig();
		modList = configuration.getList(LIST_PATH);
	}
	
	public List<?> getModList() {
		return modList;
	}
	
	public boolean getDebug() {
		return configuration.getBoolean(DEBUG_PATH);
	}
	
	public Mode getMode() {
	    switch (configuration.getString(MODE_PATH).toLowerCase()) {
	    case "whitelist":
	    	return new Whitelist();
	    default:
	    	return new Blacklist();
	    }
	}
	
	private void saveConfig() {
		if (!plugin.getDataFolder().exists())
			plugin.getDataFolder().mkdir();

		File file = new File(plugin.getDataFolder(), "config.yml");

		if (!file.exists()) {
			try (InputStream in = plugin.getResourceAsStream("config.yml")) {
				Files.copy(in, file.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void loadConfig() {
		try {
			this.configuration = ConfigurationProvider
					.getProvider(YamlConfiguration.class)
					.load(new File(plugin.getDataFolder(), "config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
