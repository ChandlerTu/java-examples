package com.chandlertu.java.examples;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class LocalDateTimeTest {

	@Test
	public void test() {

		// String text = "1967-07-16 03:32:00.123";
		// text = text.replaceAll(" ", "T");
		//
		// System.out.println(Instant.parse(text).toEpochMilli());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime localDateTime = LocalDateTime.parse("1967-07-16 03:32:00.123", formatter);
		long epochMilli = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		System.out.println(epochMilli);

	}

}
