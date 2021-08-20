package com.gauravshopping.service.impl;

import java.util.List;

import com.gauravshopping.dao.ProductDao;
import com.gauravshopping.dao.impl.ProductDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;

import com.gauravshopping.service.ProductDaoService;

public class ProductServiceImpl implements ProductDaoService {
	ProductDao pDao = new ProductDaoImpl();

	@Override
	public int CreateProduct(Product p) throws BusinessException {
		return pDao.CreateProduct(p);
	}

	@Override
	public int updateProduct(int id, float price) throws BusinessException {
		return pDao.updateProduct(id, price);
	}

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		return pDao.getAllProducts();
	}

	@Override
	public List<Product> getProductByProductName(String product_name) throws BusinessException {
		return pDao.getProductByProductName(product_name);
	}

	@Override
	public int deleteproduct(int product_id) throws BusinessException {
		
		return pDao.deleteproduct(product_id);
	}

}
