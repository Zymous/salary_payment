package com.zymous.xp.salary_payment;

import java.util.*;

public class Dates {
	public static boolean IsBetween(Date theDate, Date startDate, Date endDate) {
		Calendar calendarThis = Calendar.getInstance();
		calendarThis.setTime(theDate);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(startDate);
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(endDate);
		return calendarThis.after(calendarStart) && calendarThis.before(calendarEnd);
		
	}
}
