package com.zymous.xp.salary_payment;

import java.util.*;

public class PayrollTest {
	void TestAddSalariesEmployee() {
		int empId = 1;
		AddSalariesEmployee t = new AddSalariesEmployee(empId, "Bob", "Home", 1000.00);
		t.Execute();
		
		Employee e = GpayrollDatabase.getEmployee(empId);
		assert("Bob" == e.GetName());
		
		PaymentClassification pc = e.GetClassification();
		SalariedClassification sc = (SalariedClassification)pc;
		
		assertEquals(1000.00, sc.GetSalary(), .001);
		PaymentSchedule ps = e.GetSchedule();
		MonthlySchedule ms = (MonthlySchedule)ps;
		assert(ms);
		PaymentMethod pm = e.GetMethod();
		HoldMethod hm = (HoldMethod)pm;
		assert(hm);
	}
	void TestDeleteEmployee() {
		System.err.println("TestDeleteEmployee");
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
		t.Execute();
		{
			Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
			assert(e);
		}
		DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
		dt.Execute();
		{
			Employee e = GpayrollDatabase.GetEmployee(empId);
			assert(e == 0);
		}
		
	}
	void TestTimeCardTransaction() {
		System.err.println("TestTimeCardTransaction");
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId,"Bill","Home",15.25);
		t.Execute();
		TimeCardTransaction tct = new TimeCardTransaction(new Date(),8.0,empId);
		tct.Execute();
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
		assert(e);
		PaymentClassification pc = e.GetClassification();
		HourlyClassification hc = (HourlyClassification)pc;
		assert(hc);
		TimeCard tc = hc.GetTimeCard(new Date());
		assert(tc);
		asserEquals(8.0,tc.GetHours());
	}
	void TestAddServiceCharge() {
		System.err.println("TestAddServiceCharge");
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
		assert(e);
		int memberId = 86;
		UnionAffiliation af = new UnionAffiliation(memberId, 12.5);
		e.SetAffiliation(af);
		MemberStatic.GpayrollDatabase.AddUnionMember(memberId, e);
		ServiceChargeTransaction sct = new ServiceChargeTransaction(memberId, 20011101, 12.95);
		sct.Execute();
		ServiceCharge sc = af.GetServiceCharge(20011101);
		assert(sc);
		assertEquals(12.95, sc.GetAmount(), .001);
	}
	void TestChangeNameTransaction() {
		System.err.println("TestChangeNameTransaction");
		int empId = 2;
		AddHourlyEmployee t = new AddHourlyEmployee(empId,"Bill","Home",15.25);
		t.Execute();
		ChangeNameTransaction cnt = new ChangeNameTransaction(empId,"Bob");
		cnt.Execute();
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
		assert(e);
		assert("Bob" == e.GetName());
	}
	void TestChangeHourlyTransaction() {
		System.err.println("TestChangeHourlyTransaction");
		int empId = 3;
		AddCommissionedEmployee t = new AddCommissionedEmployee(empId,"Lance","Home",2500,3.2);
		t.Execute();
		ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId,27.52);
		cht.Execute();
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
		assert(e);
		PaymentClassification pc = e.GetClassification();
		assert(pc);
		HourlyClassification hc = (HourlyClassification)pc;
		assert(hc);
		assertEquals(27.52, hc.GetRate(), .0001);
		PaymentSchedule ps = e.GetSchedule();
		WeeklySchedule ws = (WeeklySchedule)ps;
		assert(ws);
	}
	void TestChangeMemberTransaction() {
		System.err.println("TestChangeMemberTransaction");
		int empId = 2;
		int memberId = 7734;
		AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15.25);
		t.Execute();
		ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
		cmt.Execute();
		Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId);
		assert(e);
		Affiliation af = e.GetAffiliation();
		assert(af);
		UnionAffiliation uf = (UnionAffiliation)af;
		assert(uf);
		assertEquals(99.42, uf.GetDues(), .001);
		Employee member = MemberStatic.GpayrollDatabase.GetUnionMember(memberId);
		assert(member);
		assert(e == member);
	}
	public void TestPaySingleSalariedEmployee() {
		System.err.println("TestPaySingleSalariedEmployee");
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
		t.Execute();
		Date payDate = new Date(1000*1438725620l);
		PaydayTransaction pt = new PaydayTransaction(payDate);
		pt.Execute();
		Paycheck pc = pt.GetPaycheck(empId);
		assert(pc);
		assert(pc.GetPayDate() == payDate);
		assertEquals(1000.00, pc.GetGrossPay(), .001);
		assert("Hold" == pc.GetField("Disposition"));
		assertEquals(0.0, pc.GetDeductions(), .001);
		assertEquals(1000.00, pc.GetNetPay(), .001);	
	}
	public void TestPaySingleSalariedEmployeeOnWrongDate() {
		System.err.println("TestPaySingleSalariedEmployeeWrongDate");
		int empId = 1;
		AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
		t.Execute();
		Date payDate = new Date(1000*1438725620l);
		PayDayTransaction pt = new PayDayTransaction(payDate);
		pt.Execute();
		Paycheck pc = pt.GetPaycheck(empId);
		assert(pc == 0);
	}

}
