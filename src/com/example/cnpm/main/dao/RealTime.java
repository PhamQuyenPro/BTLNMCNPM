package com.example.cnpm.main.dao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RealTime {
	private static DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	private static Calendar calendar;
	
  	public static String getCurrenTime() {
  		calendar = Calendar.getInstance();
  		return df.format(calendar.getTime());
  	}
}