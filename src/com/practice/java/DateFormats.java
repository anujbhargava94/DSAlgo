package com.practice.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormats {
	public static void main(String[] args) {
		Date dateTo = new Date(1565976180671L);
		//156634560000
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String formatted = format.format(dateTo);
		System.out.println("Date formatted: " + formatted);
	}
}
