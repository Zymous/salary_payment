package com.zymous.xp.salary_payment;
import java.util.*;

public class PayrollDatabase {
	private Map<Integer, Employee> itsEmployees;
	public Employee GetEmployee(int empId) {
		return itsEmployees[empId];
	}
	public void AddEmployee(int empid, Employee e) {
		itsEmployees[empid] = e;
	}
	public void clear() {
		itsEmployees.clear();
	}
	public void DeleteEmployee(int empid) {
		
	}
}
