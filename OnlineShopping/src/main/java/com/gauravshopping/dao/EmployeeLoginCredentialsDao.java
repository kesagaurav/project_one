package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;

public interface EmployeeLoginCredentialsDao {

	public boolean addEmployeeCredentials(String username, String password) throws BusinessException;

}
