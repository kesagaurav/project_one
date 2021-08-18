package com.gauravshopping.service.impl;

import com.gauravshopping.dao.ProductDao;
import com.gauravshopping.dao.impl.ProductDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;
//import com.gauravshopping.product.dao.ProductDao;
//import com.gauravshopping.product.dao.impl.ProductDaoImpl;
//import com.gauravshopping.product.service.ProductDaoService;
import com.gauravshopping.service.ProductDaoService;

public class ProductServiceImpl implements ProductDaoService {
ProductDao pDao=new ProductDaoImpl();
	@Override
	public int CreateProduct(Product p) throws BusinessException {
		// TODO Auto-generated method stub
		return pDao.CreateProduct(p);
	}
	@Override
	public int updateProduct(int id, float price) throws BusinessException {
		// TODO Auto-generated method stub
		return pDao.updateProduct(id, price);
	}

}
