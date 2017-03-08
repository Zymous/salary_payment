package com.zymous.xp.salary_payment;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction{
	private String itsAddress;
	public ChangeAddressTransaction(int empid, String address) {
		super(empid);
		itsAddress = address;
	}
	public void Change(Employee e) {
		e.SetAddress(itsAddress);
	}
}
