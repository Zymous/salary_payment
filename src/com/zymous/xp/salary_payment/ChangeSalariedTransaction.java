package com.zymous.xp.salary_payment;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
	private double itsSalary;
	public ChangeSalariedTransaction(int empid, double salary) {
		super(empid);
		itsSalary = salary;
	}
	public PaymentClassification GetClassification() {
		return new SalariedClassification(itsSalary);
	}
	public PaymentSchedule GetSchedule() {
		return new MonthlySchedule();
	}
}
