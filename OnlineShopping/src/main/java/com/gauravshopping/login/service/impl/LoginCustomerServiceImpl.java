package com.gauravshopping.login.service.impl;

import com.gauravshopping.dao.CustomerLoginCredentialsDao;
import com.gauravshopping.dao.impl.CustomerLoginCredentialsDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.login.service.LoginCustomerService;

public class LoginCustomerServiceImpl implements LoginCustomerService {
	CustomerLoginCredentialsDao customerLoginCredentials  = new CustomerLoginCredentialsDaoImpl();
	
	@Override
	public int addCredentials(String email, String password) throws BusinessException {
		if(!CustomerLoginCredentials.isValidUsernameAndPassword(email, password)) {
			throw new BusinessException("\n invalid username and password ");
		}
		
		return customerLoginCredentials.addCredentials(email, password);
	}

	
	
}
