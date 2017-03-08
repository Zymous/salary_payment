package com.zymous.xp.salary_payment;

import java.util.*;

public class ServiceChargeTransaction {
	private int itsMemberId;
	private Date itsDate;
	private double itsCharge;
	
	public ServiceChargeTransaction(int memberId, Date date, double charge) {
		itsMemberId = memberId;
		itsDate = date;
		itsCharge = charge;
	}
	public void Execute() {
		Employee e = MemberStatic.GpayrollDatabase.GetUnionMember(itsMemberId);
		Affiliation af = e.GetAffiliation();
		if (UnionAffiliation uaf = (UnionAffiliation)af) {
			uaf.AddServiceCharge(itsDate,itsCharge);
		}
	}
}
