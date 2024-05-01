package com.naveenautomationlabs.AFramework.pages;

public class Employee {
	int employee_id;
// String first_name;
// String last_name;
	String email;

// String phone_number;
// int job_id;
// double salary;
// int manager_id;
// int department_id;
// String hire_date;
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    public String toString() {
		return "email: "+email+" employee_id: "+employee_id;
    	
    }
}
