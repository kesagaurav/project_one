package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerService {
	public int createCustomer(Customer c) throws BusinessException;
}
