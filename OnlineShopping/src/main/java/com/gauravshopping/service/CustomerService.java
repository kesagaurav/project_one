package com.gauravshopping.service;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerService {
	public int createCustomer(Customer c) throws BusinessException;
	public  List<Customer> getAllCustomers() throws BusinessException;
	public int deleteCustomer(int customer_id) throws BusinessException;
}
