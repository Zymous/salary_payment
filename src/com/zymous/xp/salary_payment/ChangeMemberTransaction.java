package com.zymous.xp.salary_payment;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
	private int itsMemberId;
	private double itsDues;
	ChangeMemberTransaction(int empid,int memberId, double dues) {
		super(empid);
		itsMemberId = memberId;
		itsDues = dues;
	}
	public Affiliation GetAffiliation() {
		return new UnionAffiliation(itsMemberId, itsDues);
	}
	public void RecordMembership(Employee e) {
		MemberStatic.GpayrollDatabase.AddUnionMember(itsMemberId, e);
	}
}
