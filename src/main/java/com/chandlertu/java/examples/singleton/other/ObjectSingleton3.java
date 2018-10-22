package com.chandlertu.java.examples.singleton.other;

public class ObjectSingleton3 {

	private volatile static Object uniqueInstance;

	public static Object getInstance() {
		if (uniqueInstance == null) {
			synchronized (ObjectSingleton3.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Object();
				}
			}
		}
		return uniqueInstance;
	}

}
