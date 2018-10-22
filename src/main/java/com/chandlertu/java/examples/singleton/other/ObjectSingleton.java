package com.chandlertu.java.examples.singleton.other;

public class ObjectSingleton {

	private static Object uniqueInstance;

	public static Object getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Object();
		}
		return uniqueInstance;
	}

}
