package com.gauravshopping.dao;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;

public interface ProductDao {

	public int CreateProduct(Product p) throws BusinessException;
	public int updateProduct(int id,float price) throws BusinessException;
	public List<Product> getAllProducts() throws BusinessException;
	public List<Product> getProductByProductName(String product_name) throws BusinessException;
	public int deleteproduct(int product_id) throws BusinessException;
}



