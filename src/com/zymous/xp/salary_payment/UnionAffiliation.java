package com.zymous.xp.salary_payment;

import java.util.*;

public class UnionAffiliation {
	public int NumberOfFridaysInPayPeriod(Date payPeriodStart, Date payPeriodEnd) {
		int fridays = 0;
		Calendar start = Calendar.getInstance();
		start.setTime(payPeriodStart);
		Calendar end = Calendar.getInstance();
		end.setTime(payPeriodEnd);
		while(start.before(end)) {
			if(start.get(Calendar.DAY_OF_WEEK) == 6) {
				fridays++;
			}
			start.add(Calendar.DATE, 1);
		}
		return fridays;
	}
	public double CalculateDeductions(Paycheck pc) {
		double totalDues = 0;
		int fridays = NumberOfFridaysInPayPeriod(pc.GetPayPeriodStartDate(),pc.GetPayPeriodEndDate());
		totalDues = itsDues * fridays;
		return totalDues;
	}
}
