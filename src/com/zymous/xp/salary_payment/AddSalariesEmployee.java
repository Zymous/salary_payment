package com.zymous.xp.salary_payment;

public class AddSalariesEmployee extends AddEmployeeTransaction {
	private double itsSalary;
	AddSalariesEmployee(int empid, String name, String address, double salary) {
		super(empid,name,address);
		itsSalary = salary;
	}
	PaymentClassification GetClassification() {
		return new SalariedClassfication(itsSalary);
	}
	PaymentSchedule GetSchedule() {
		return new MonthlySchedule();
	}
}
