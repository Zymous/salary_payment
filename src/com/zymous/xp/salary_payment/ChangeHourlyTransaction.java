package com.zymous.xp.salary_payment;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
	private double itsHourlyRate;
	public ChangeHourlyTransaction(int empid, double hourlyRate) {
		super(empid);
		itsHourlyRate = hourlyRate;
	}
	public PaymentSchedule GetSchedule() {
		return new WeeklySchedule();
	}
	public PaymentClassification GetClassification() {
		return new HourlyClassification(itsHourlyRate);
	}
}
