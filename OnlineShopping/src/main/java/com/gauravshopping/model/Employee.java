package com.gauravshopping.model;

public class Employee {

	private int employee_id;
	private String employee_name;
	private String employee_pasword;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int employee_id, String employee_name, String employee_pasword) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_pasword = employee_pasword;
	}



	public int getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}



	public String getEmployee_name() {
		return employee_name;
	}



	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}



	public String getEmployee_pasword() {
		return employee_pasword;
	}



	public void setEmployee_pasword(String employee_pasword) {
		this.employee_pasword = employee_pasword;
	}



	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_pasword="
				+ employee_pasword + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
