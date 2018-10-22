package com.chandlertu.java.examples.singleton.other;

public class ObjectSingleton2 {

	private static Object uniqueInstance = new Object();

	public static Object getInstance() {
		return uniqueInstance;
	}

}
