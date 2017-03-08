package com.zymous.xp.salary_payment;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
	ChangeMethodTransaction(int empid) {
		super(empid);
	}
	abstract void Change(Employee e) {
		e.SetMethod(GetMethod());
	}
	abstract PaymentMethod GetMethod();
}
