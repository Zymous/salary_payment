package com.zymous.xp.salary_payment;

abstract public class ChangeEmployeeTransaction extends Transaction {
	private int itsEmpId;
	public ChangeEmployeeTransaction(int empid) {
		itsEmpId = empid;
	}
	abstract void Change(Employee e);
	void Execute() {
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(itsEmpId);
		if(e !=0) {
			Change(e);
		}
	}
}
