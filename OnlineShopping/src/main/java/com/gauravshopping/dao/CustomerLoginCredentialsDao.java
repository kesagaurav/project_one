package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;

public interface CustomerLoginCredentialsDao {

	public int addCredentials(String email,String password) throws BusinessException;
	
}
