package com.zymous.xp.salary_payment;

import java.util.*;

public class SalesReceiptTransaction extends Transaction{
	private int itsEmpid;
	private double itsAmount;
	private Date itsDate;
	public SalesReceiptTransaction(int empid, double amount, Date date) {
		itsEmpid = empid;
		itsAmount = amount;
		itsDate = date;
	}
	public void Execute() throws Exception {
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(itsEmpid);
		if (e) {
			PaymentClassification pc = e.GetClassification();
			if(CommissionedClassification cc = (CommissionedClassification)pc) {
				cc.AddSalesReceipt(new SalesReceipt(itsAmount,itsDate));
			} else {
				throw new Exception("Tried to add timecard to non-sales employee");
			}
		} else {
			throw new Exception("No such employee");
		}
	}
}
