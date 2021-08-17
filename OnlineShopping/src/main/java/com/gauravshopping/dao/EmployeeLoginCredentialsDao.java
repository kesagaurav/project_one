package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;

public interface EmployeeLoginCredentialsDao {

	public int addEmployeeCredentials(String username,String password) throws BusinessException;
	
	
}
