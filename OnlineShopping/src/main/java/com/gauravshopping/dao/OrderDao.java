package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;

public interface OrderDao {

	public int AddProductToOrder(Cart cart) throws BusinessException;
	
	
}
