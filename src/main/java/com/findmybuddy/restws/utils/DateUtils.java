package com.findmybuddy.restws.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getDateAsString(Date date){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyy hh:mm:ss");
		String strDate = dateFormat.format(date);
		return strDate;
	}

}
