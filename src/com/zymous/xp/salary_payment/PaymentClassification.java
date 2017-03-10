package com.zymous.xp.salary_payment;

import java.util.*;

public class PaymentClassification {
	public boolean IsInPayPeriod(Date theDate, Paycheck pc) {
		Date payPeriodEndDate = pc.GetPayPeriodEndDate();
		Date payPeriodStartDate = pc.GetPayPeriodStartDate();
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(payPeriodEndDate);
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(payPeriodStartDate);
		Calendar date = Calendar.getInstance();
		date.setTime(theDate);
		return date.after(startDate)&&date.before(endDate);
	}
}
