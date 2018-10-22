package com.chandlertu.java.examples.singleton.other;

public class ObjectSingleton1 {

	private static Object uniqueInstance;

	public static synchronized Object getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Object();
		}
		return uniqueInstance;
	}

}
