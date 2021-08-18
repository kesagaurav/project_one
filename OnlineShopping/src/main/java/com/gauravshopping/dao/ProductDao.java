package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;

public interface ProductDao {

	public int CreateProduct(Product p) throws BusinessException;
	public int updateProduct(int id,float price) throws BusinessException;
}



