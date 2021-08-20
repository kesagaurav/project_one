package com.gauravshopping.dao;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;

public interface CartDao {

	public int addProduct(Cart cart) throws BusinessException;
	public List<Cart> getAllCartDetails(Cart cart) throws BusinessException;
	
	
}
