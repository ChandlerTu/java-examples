package com.chandlertu.java.examples;

public class SystemProperties {

	public static void main(String[] args) {
		System.getProperties().forEach((k, v) -> System.out.println(k + ": " + v));
		System.getenv().forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
