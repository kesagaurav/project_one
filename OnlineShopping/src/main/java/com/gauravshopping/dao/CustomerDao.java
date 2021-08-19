package com.gauravshopping.dao;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerDao {

		public int createCustomer(Customer customer) throws BusinessException;
		public  List<Customer> getAllCustomers() throws BusinessException;
	
}
