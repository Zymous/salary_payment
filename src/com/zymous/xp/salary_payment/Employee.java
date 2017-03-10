package com.zymous.xp.salary_payment;

public class Employee {
	
	private int itsEmpid;
	private String itsName;
	private String itsAddress;
	private PaymentClassification itsClassification;
	private PaymentSchedule itsSchedule;
	private PaymentMethod itsPaymentMethod;
	private Affiliation itsAffiliation;
	
	public Employee(int empid, String name, String address) {
		itsEmpid = empid;
		itsName = name;
		itsAddress = address;
		itsAffiliation = new NoAffiliation();
	}
	public void SetName(String name) {
		itsName = name;
	}
	public void SetAddress(String address) {
		itsAddress = address;
	}
	public void SetClassification(PaymentClassification pc) {
		itsClassification = pc;
	}
	public void SetSchedule(PaymentSchedule ps) {
		itsSchedule = ps;
	}
	public void SetMethod(PaymentMethod pm) {
		itsPaymentMethod = pm;
	}
	public void SetAffiliation(Affiliation af) {
		itsAffiliation = af;
	}
}
