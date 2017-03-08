package com.zymous.xp.salary_payment;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
	private double itsSalary;
	private double itsCommissionRate;
	AddCommissionedEmployee(int empid, String name, String address,double salary,double commissionRate) {
		super(empid,name,address);
		itsSalary = salary;
		itsCommissionRate = commissionRate;
	}
	PaymentClassification GetClassification() {
		return new CommissionedClassfication(itsSalary,itsCommissionRate);
	}
	PaymentSchedule GetSchedule() {
		return new BiweeklySchedule();
	}
}
