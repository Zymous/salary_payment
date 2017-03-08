package com.zymous.xp.salary_payment;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
	private double itsSalary;
	private double itsCommissionRate;
	public ChangeCommissionedTransaction(int empid, double salary, double commissionRate) {
		super(empid);
		itsSalary = salary;
		itsCommissionRate = commissionRate;
	}
	public PaymentSchedule GetSchedule() {
		return new BiweeklySchedule();
	}
	public PaymentClassification GetClassification() {
		return new CommissionedClassification(itsCommissionRate,itsSalary);
	}
	
}
