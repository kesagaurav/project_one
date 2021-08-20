package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;

public interface LoginCustomerService {
	public boolean addCredentials(String email,String password) throws BusinessException;
}
