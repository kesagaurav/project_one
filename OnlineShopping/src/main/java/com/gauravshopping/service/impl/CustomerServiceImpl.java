package com.gauravshopping.service.impl;

import java.util.List;

import com.gauravshopping.dao.CustomerDao;
import com.gauravshopping.dao.impl.CustomerDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public int createCustomer(Customer c) throws BusinessException {
		if (!CustomerValidation.isValidId(c.getCustomer_id())) {
			throw new BusinessException(" invalid player id  " + c.getCustomer_id() + "please give valid id");
		}
		if (!CustomerValidation.isValidFirstName(c.getFirst_name())) {
			throw new BusinessException(
					"invalid customer firstname it should be minimum of 3 characters and min of 1 number " + c.getFirst_name() + " please give valid fisrtname ");
		}
		if (!CustomerValidation.isValidLastName(c.getLast_name())) {
			throw new BusinessException(
					"invalid customer lastname it should be minimum of 3 characters and min of 1 number " + c.getLast_name() + "please enter valid lastname");
		}
//		if (!CustomerValidation.isValidEmail(c.getEmail())) {
//			throw new BusinessException("invalid email " + c.getEmail()  + " please enter valid email ");
//		}

		if (!CustomerValidation.isValidPassword(c.getPassword())) {
			throw new BusinessException("invalid password  because it should be min of 3 characters and min of 1 number" + c.getPassword() + "please enter valid password");
		}
		return customerDao.createCustomer(c);
	}

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public int deleteCustomer(int customer_id) throws BusinessException {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomer(customer_id);
	}

}
