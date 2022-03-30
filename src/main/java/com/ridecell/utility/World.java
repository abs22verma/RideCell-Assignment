package com.ridecell.utility;

import java.util.HashMap;

public class World {

	private static World world;
	private final HashMap<String, String> worldMap = new HashMap<>();

	public static World getInstance() {
		if (world == null) {
			world = new World();
		}
		return world;
	}

	public void add(String key, String value) {
		worldMap.put(key, value);
	}

	public String get(String key) {
		return worldMap.get(key);
	}

	public boolean search(String key) {
		return worldMap.containsKey(key);
	}
}
