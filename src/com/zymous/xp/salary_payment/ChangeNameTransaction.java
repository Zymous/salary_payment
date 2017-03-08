package com.zymous.xp.salary_payment;

public class ChangeNameTransaction extends ChangeEmployeeTransaction{
	private String itsName;
	public ChangeNameTransaction(int empid, String name) {
		super(empid);
		itsName = name;
	}
	void Change(Employee e) {
		e.SetName(itsName);
	}
}
