package com.gauravshopping.service.impl;

import com.gauravshopping.dao.CustomerProductDao;
import com.gauravshopping.dao.impl.CustomerProductDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.service.CustomerProductService;

public class CustomerProductServiceImpl implements CustomerProductService {
CustomerProductDao cpDao=new CustomerProductDaoImpl();
	@Override
	public int addProduct(Customer c) throws BusinessException {
		// TODO Auto-generated method stub
		return cpDao.addProduct(c);
	}

}
