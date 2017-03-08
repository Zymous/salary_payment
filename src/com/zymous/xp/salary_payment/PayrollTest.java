package com.zymous.xp.salary_payment;

public class PayrollTest {

	void TestAddSalariesEmployee() {
		int empId = 1;
		AddSalariedEmployee t(empId, "Bob", "Home", 1000.00);
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
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
