package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerProductService {

	public int addProduct(Customer c) throws BusinessException;

	
	
}
