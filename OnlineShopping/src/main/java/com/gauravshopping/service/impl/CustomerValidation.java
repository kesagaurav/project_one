package com.gauravshopping.service.impl;

public class CustomerValidation {

	public static boolean isValidId(int id) {
		if(id<10 && id>100) {
			return false;
			
		}else {
			return true;
		}
		
	}
	
	
	public static boolean isValidFirstName(String first_name) {
		if(first_name!=null && first_name.matches("[a-zA-Z]{3,20}[0-9]{1,9}")) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean isValidLastName(String last_name) {
		if(last_name!=null && last_name.matches("[a-zA-Z]{3,20}[0-9]{1,9}")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public static boolean isValidEmail(String email) {
		if(email!=null && email.matches("[a-zA-Z]{3,20} ")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValidPassword(String password) {
		if(password!=null && password.matches("[a-zA-Z]{3,20}[0-9]{1,9}")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
