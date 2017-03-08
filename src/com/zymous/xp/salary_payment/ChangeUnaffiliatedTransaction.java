package com.zymous.xp.salary_payment;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
	ChangeUnaffiliatedTransaction(int empid) {
		super(empid);
	}
	public Affiliation GetAffiliation() {
		return new NoAffiliation();
	}
	public void RecordMembership(Employee e) {
		Affiliation af = e.GetAffiliation();
		if (UnionAffiliation uf = (UnionAffiliation)af) {
			int memberId = uf.GetMemberId();
			MemberStatic.GpayrollDatabase.RemoveUnionMember(memberId);
		}
	}
}
