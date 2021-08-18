package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;

public interface EmployeeLoginCredentialsDao {

	public String addEmployeeCredentials(String username, String password) throws BusinessException;

}
