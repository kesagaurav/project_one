package com.gauravshopping.service.impl;

public class EmployeeLoginCredentials {
	public static boolean isValidUsernameAndPassword(String username, String password) {

		if (username.equals("kesagaurav@yahoo.com") && password.equals("gaurav123456")) {
			return true;
		}

		return false;

	}
}
