package com.zymous.xp.salary_payment;

import java.util.*;

public class WeeklySchedule {
	boolean IsPayDate(Date theDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		return calendar.get(Calendar.DAY_OF_WEEK) == 5;
	}
}
