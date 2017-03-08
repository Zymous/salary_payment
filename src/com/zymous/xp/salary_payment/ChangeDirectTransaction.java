package com.zymous.xp.salary_payment;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
	private String itsBank;
	private double itsAccount;
	public ChangeDirectTransaction(int empid, String bank, double account) {
		super(empid);
		itsBank = bank;
		itsAccount = account;
	}
	public PaymentMethod GetMethod() {
		return new DirectMethod(itsBank,itsAccount);
	}
}
