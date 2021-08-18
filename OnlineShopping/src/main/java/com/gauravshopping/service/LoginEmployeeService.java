package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;

public interface LoginEmployeeService {
	public String addEmployeeCredentials(String username,String password) throws BusinessException;

}
