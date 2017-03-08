package com.zymous.xp.salary_payment;

import java.util.*;

public class TimeCardTransaction extends Transaction{
	private int itsEmpid;
	private Date itsDate;
	private double itsHours;
	public TimeCardTransaction(Date date, double hours, int empid) {
		itsDate = date;
		itsHours = hours;
		itsEmpid = empid;
	}
	public void Execute() throws Exception {
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(itsEmpid);
		if (e) {
			PaymentClassification pc = e.GetClassification();
			if(HourlyClassification hc = (HourlyClassification)pc) {
				hc.AddTimeCard(new TimeCard(itsDate,itsHours));
			} else {
				throw new Exception("Tried to add timecard to non-hourly employee");
			}
		} else {
			throw new Exception("No such employee");
		}
	}
}
