package com.zymous.xp.salary_payment;

public class AddEmployeeTransaction extends Transaction {
	private int itsEmpid;
	private String itsName;
	private String itsAddress;
	AddEmployeeTransaction(int empid, String name, String address) {
		itsEmpid = empid;
		itsName = name;
		itsAddress = address;
	}
	void Execute() {
		PaymentClassificatipn pc = GetClassification();
		PaymentSchedule ps = GetSchedule();
		PaymentMethod pm = new HoldMethod();
		Employee e = new Employee(itsEmpid, itsName, itsAddress);
		e.SetClassfication(pc);
		e.SetSchedule(ps);
		e.SetMethod(pm);
		MemberStatic.GpayrollDatabase.AddEmployee(itsEmpid, e);
	}
	abstract PaymentClassfication GetClassification();
	abstract PaymentSchedule GetSchedule();
}
