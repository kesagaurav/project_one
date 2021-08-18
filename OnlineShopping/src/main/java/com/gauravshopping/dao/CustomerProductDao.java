package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerProductDao {

	public int addProduct(Customer c) throws BusinessException;
	
}
