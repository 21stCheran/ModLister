package com.twentyonec.ModLister;

import com.twentyonec.ModLister.events.Join;
import com.twentyonec.ModLister.utils.Config;

import net.md_5.bungee.api.plugin.Plugin;

public class ModLister extends Plugin {
	static ModLister modLister = null;
	Config config = null;
	Boolean debug = false;

	@Override
	public void onEnable() {
		modLister = this;	
		config = new Config();
		debug = config.getDebug();
		getProxy().getPluginManager().registerListener(this, new Join());
	}

	public static ModLister getPlugin() {
		return modLister;
	}
	public Config getConfig() {
		return config;
	}
	
	public void debug(String msg) {
		if (this.debug) {
			this.getLogger().info(msg);
		}
	}


}
