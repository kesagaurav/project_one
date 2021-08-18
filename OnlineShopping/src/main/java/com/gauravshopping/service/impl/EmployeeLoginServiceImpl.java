package com.gauravshopping.service.impl;

import com.gauravshopping.dao.EmployeeLoginCredentialsDao;
import com.gauravshopping.dao.impl.EmployeeCredentialsDaoImpl;
import com.gauravshopping.exception.BusinessException;
//import com.gauravshopping.login.service.LoginEmployeeService;
import com.gauravshopping.service.LoginEmployeeService;

public class EmployeeLoginServiceImpl implements LoginEmployeeService {
	EmployeeLoginCredentialsDao ecDao=new EmployeeCredentialsDaoImpl();
	@Override
	public String addEmployeeCredentials(String username, String password) throws BusinessException {
		if(!EmployeeLoginCredentials.isValidUsernameAndPassword(username, password)) {
			throw new BusinessException("\n invalid username and password");
		}
		return ecDao.addEmployeeCredentials(username, password);
	}

	
}
