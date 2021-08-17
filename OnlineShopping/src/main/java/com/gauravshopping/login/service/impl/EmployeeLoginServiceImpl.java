package com.gauravshopping.login.service.impl;

import com.gauravshopping.dao.EmployeeLoginCredentialsDao;
import com.gauravshopping.dao.impl.EmployeeCredentialsDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.login.service.LoginEmployeeService;

public class EmployeeLoginServiceImpl implements LoginEmployeeService {
	EmployeeLoginCredentialsDao ecDao=new EmployeeCredentialsDaoImpl();
	@Override
	public int addEmployeeCredentials(String username, String password) throws BusinessException {
		if(!EmployeeLoginCredentials.isValidUsernameAndPassword(username, password)) {
			throw new BusinessException("\n invalid suername and password");
		}
		return ecDao.addEmployeeCredentials(username, password);
	}

	
}
