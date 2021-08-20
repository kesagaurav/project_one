package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;

public interface LoginEmployeeService {
	public boolean addEmployeeCredentials(String username,String password) throws BusinessException;

}
