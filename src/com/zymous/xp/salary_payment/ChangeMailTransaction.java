package com.zymous.xp.salary_payment;

public class ChangeMailTransaction extends ChangeMethodTransaction {
	private String itsAddress;
	ChangeMailTransaction(int empid, String address) {
		super(empid);
		itsAddress = address;
	}
	public PaymentMethod GetMethod() {
		return new MailMethod(itsAddress);
	}
}
