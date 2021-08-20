package com.gauravshopping.service.impl;

import java.util.List;

import com.gauravshopping.dao.CustomerSearchDao;
import com.gauravshopping.dao.impl.CustomerSearchDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.service.CustomerSearchService;

public class CustomerSearchServiceImpl implements CustomerSearchService {
	private CustomerSearchDao customerSearchDao = new CustomerSearchDaoImpl();

	@Override
	public Customer GetCustomerById(int customer_id) throws BusinessException {

		return customerSearchDao.GetCustomerById(customer_id);
	}

	@Override
	public List<Customer> getStringByFirstName(String firstname) throws BusinessException {

		return customerSearchDao.getStringByFirstName(firstname);
	}

	@Override
	public List<Customer> getStringByLastName(String lastname) throws BusinessException {

		return customerSearchDao.getStringByLastName(lastname);
	}

	@Override
	public List<Customer> getStringByEmail(String email) throws BusinessException {

		return customerSearchDao.getStringByEmail(email);
	}

	

}