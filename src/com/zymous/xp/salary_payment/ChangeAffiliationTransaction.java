package com.zymous.xp.salary_payment;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
	ChangeAffiliationTransaction(int empid) {
		super(empid);
	}
	public abstract void Change(Employee e) {
		RecordMembership(e);
		e.SetAffiliation(GetAffiliation());
	}
	public abstract Affiliation GetAffiliation();
	public abstract void RecordMembership(Employee e);
}
