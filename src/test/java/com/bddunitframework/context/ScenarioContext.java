package com.bddunitframework.context;

import java.util.HashMap;

public class ScenarioContext {
	private HashMap<String, Object> bag = new HashMap<>();

	public HashMap<String, Object> getBag() {
		return bag;
	}
}
