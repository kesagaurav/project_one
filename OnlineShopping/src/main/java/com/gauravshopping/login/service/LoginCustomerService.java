package com.gauravshopping.login.service;

import com.gauravshopping.exception.BusinessException;

public interface LoginCustomerService {
	public String addCredentials(String email,String password) throws BusinessException;
}
