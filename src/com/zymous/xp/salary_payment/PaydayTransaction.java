package com.zymous.xp.salary_payment;

import java.util.*;

public class PaydayTransaction {
	public void Execute() {
		List<Integer> empIds;
		MemberStatic.GpayrollDatabase.GetAllEmployeeIds(empIds);
		Iterator i = empIds.iterator();
		while(i.hasNext()) {
			int empId = (int)i.next();
			if(Employee e = MemberStatic.GpayrollDatabase.GetEmployee(empId)) {
				if(e.IsPayDate(itsPayDate)) {
					Paycheck pc = new Paycheck(e.GetPayPeriodStartDate(itsPayDate),itsPayDate);
					itsPaychecks[empId] = pc;
					e.Payday(pc);
				}
			}
		}
	}
}
