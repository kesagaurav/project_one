package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;

public interface CustomerLoginCredentialsDao {

	public boolean addCredentials(String email,String password) throws BusinessException;
	
}
