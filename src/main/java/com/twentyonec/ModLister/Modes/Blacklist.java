package com.twentyonec.ModLister.Modes;

import java.util.Map;

public class Blacklist implements Mode {

	@Override
	public void playerJoins(Map<String, String> mods) {
		System.out.println("Blacklist");
	}
}
