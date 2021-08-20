package com.gauravshopping.dao;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Order;

public interface CustomerSearchDao {

	public Customer GetCustomerById(int customer_id) throws BusinessException;
	public List<Customer> getStringByFirstName(String firstname) throws BusinessException;
	public List<Customer> getStringByLastName(String lastname) throws BusinessException;
	public List<Customer> getStringByEmail(String email) throws BusinessException;

	
	
	
}
