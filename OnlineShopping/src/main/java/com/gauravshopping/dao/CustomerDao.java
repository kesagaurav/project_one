package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerDao {

		public int createCustomer(Customer customer) throws BusinessException;
	
}
