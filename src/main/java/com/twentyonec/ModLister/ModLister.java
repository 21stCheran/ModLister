package com.twentyonec.ModLister;

  import java.util.List;

import com.twentyonec.ModLister.utils.Config;

import net.md_5.bungee.api.plugin.Plugin;

public class ModLister extends Plugin {
	static ModLister modLister = null;
	Config config = null;
	Mode mode;
	List<?> list = null;
	Boolean debug = false;

	@Override
	public void onEnable() {
		modLister = this;	
		config = new Config();
		list = config.getModList();
		debug = config.getDebug();
		setMode();
	}

	public static ModLister getPlugin() {
		return modLister;
	}
	public Mode getMode() {
		return mode;
	}
	public List<?> getList() {
		return list;
	}
	
	private void setMode() {
		this.mode = (config.getMode().equalsIgnoreCase("whitelist"))
				? new Whitelist()
				: new Blacklist();
	}
	
	public void debug(String msg) {
		if (this.debug) {
			this.getLogger().info(msg);
		}
	}


}
