package com.zymous.xp.salary_payment;

import java.util.*;

public class HourlyClassification {
	double CalculatePay(Paycheck pc) {
		double totalPay = 0;
		Date payPeriod = pc.GetPayDate();
		Map<Date, TimeCard> m = new HashMap<Date, TimeCard>();
		Iterator i = m.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry<Date, TimeCard> entry = (Map.Entry<Date, TimeCard>)i.next();
			TimeCard tc = entry.getValue();
			if(IsInPayPeriod(tc, payPeriod)) {
				totalPay +=CalculatePayForTimeCard(tc);
			}
		}
		return totalPay;
	}
	boolean IsInPayPeriod(TimeCard tc, Date payPeriod) {
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(payPeriod);
		Calendar calendarStr = Calendar.getInstance();
		calendarStr.add(calendarEnd.DAY_OF_YEAR, -5);
		Calendar calendarTimeCard = Calendar.getInstance();
		calendarTimeCard.setTime(tc.GetDate());
		return (calendarTimeCard.after(calendarStr)&&calendarTimeCard.before(calendarEnd));
	}
	double CalculatePayForTimeCard(TimeCard tc) {
		double hours = tc.GetHours();
		double overtime = Math.max(0.0, hours-8.0);
		double straightTime = hours - overtime;
		return straightTime * itsRate + overtime * itsRate * 1.5;
	}
}
