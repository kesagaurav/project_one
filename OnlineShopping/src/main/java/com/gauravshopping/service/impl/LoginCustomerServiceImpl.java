package com.gauravshopping.service.impl;

import com.gauravshopping.dao.CustomerLoginCredentialsDao;
import com.gauravshopping.dao.impl.CustomerLoginCredentialsDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.service.LoginCustomerService;
//import com.gauravshopping.login.service.LoginCustomerService;

public class LoginCustomerServiceImpl implements LoginCustomerService {
	CustomerLoginCredentialsDao customerLoginCredentials  = new CustomerLoginCredentialsDaoImpl();
	
	@Override
	public String addCredentials(String email, String password) throws BusinessException {
		if(!CustomerLoginCredentials.isValidUsernameAndPassword(email, password)) {
			throw new BusinessException("\n invalid username and password ");
		}
		return customerLoginCredentials.addCredentials(email, password);
		
	
	}

	
	
}
