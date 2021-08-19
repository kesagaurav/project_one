package com.gauravshopping.service;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;

public interface CustomerSearchService {

	public Customer GetCustomerById(int customer_id) throws BusinessException;
	public List<Customer> getStringByFirstName(String firstname) throws BusinessException;
	public List<Customer> getStringByLastName(String lastname) throws BusinessException;
	public List<Customer> getStringByEmail(String email) throws BusinessException;
	public List<Customer> getStringByPassword(String password) throws BusinessException;
}
