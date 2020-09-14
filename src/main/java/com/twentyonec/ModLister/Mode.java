package com.twentyonec.ModLister;

interface Mode {	
	void playerJoins();
}

class Whitelist implements Mode {

	@Override
	public void playerJoins() {
		System.out.println("Whitelist");
	}
	
}

class Blacklist implements Mode {

	@Override
	public void playerJoins() {
		System.out.println("Blacklist");
	}
	
}
