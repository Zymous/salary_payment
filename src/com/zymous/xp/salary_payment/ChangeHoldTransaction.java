package com.zymous.xp.salary_payment;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
	private String itsAddress;
	public ChangeHoldTransaction(int impid, String address) {
		super(impid);
		itsAddress = address;
	}
	public PaymentMethod GetMethod() {
		return new HoldMethod(itsAddress);
	}
}
