package com.gauravshopping.service.impl;

public class CustomerLoginCredentials {

	public static boolean isValidUsernameAndPassword(String username, String password) {

		if (username.equals("kesagaurav@gmail.com") && password.equals("gaurav123456")) {

			return true;
		}

		return false;

	}

}
