package com.zymous.xp.salary_payment;

public class DeleteEmployeeTransaction extends Transaction{
	private int itsEmpid;
	public DeleteEmployeeTransaction(int empid) {
		itsEmpid = empid;
	}
	void Execute() {
		MemberStatic.GpayrollDatabase.DeleteEmployee(itsEmpid);
	}
}
