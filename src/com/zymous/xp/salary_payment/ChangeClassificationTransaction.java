package com.zymous.xp.salary_payment;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
	ChangeClassificationTransaction(int empid) {
		super(empid);
	}
	abstract void Change(Employee e) {
		e.SetClassification(GetClassification());
		e.SetSchedule(GetSchedule());
	}
	abstract PaymentClassification GetClassification();
	abstract PaymentSchedule GetSchedule();
}
