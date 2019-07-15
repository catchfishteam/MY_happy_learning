package com.shenzk.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
	
	public static void main(String[] args) {
//		getDay();
		test1();
	}
	
	public static void getDay(){
		DateFormat format = DateFormat.getDateInstance();
		System.out.println(format.format(new Date()));
	}
	
	public static void test1(){
		Date date = new Date();
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
		System.out.println(format.format(date.getTime()-60*60*24*1000));
		
	}

}
