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

}
