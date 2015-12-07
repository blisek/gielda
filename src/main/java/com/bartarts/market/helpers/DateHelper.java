package com.bartarts.market.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static final String DATABASE_DATE_MUSTER = "yyyy-MM-dd";

	public static Date parseDate(String muster, String date)
			throws ParseException {
		return new SimpleDateFormat(muster).parse(date);
	}
}
