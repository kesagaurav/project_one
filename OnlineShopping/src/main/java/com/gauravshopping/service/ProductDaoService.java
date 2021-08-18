package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;

public interface ProductDaoService {
	public int CreateProduct(Product p) throws BusinessException;
	public int updateProduct(int id,float price) throws BusinessException;


}
