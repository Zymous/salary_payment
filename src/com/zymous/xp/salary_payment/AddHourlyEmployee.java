package com.zymous.xp.salary_payment;

public class AddHourlyEmployee extends AddEmployeeTransaction {
	private double itsHourlyRate;
	AddHourlyEmployee(int empid, String name, String address, double hourlyRate) {
		super(empid,name,address);
		itsHourlyRate = hourlyRate;
	}
	PaymentClassification GetClassification() {
		return new HourlyClassification(itsHourlyRate);
	}
	PaymentSchedule GetSchedule() {
		return new WeeklySchedule();
	}
}
