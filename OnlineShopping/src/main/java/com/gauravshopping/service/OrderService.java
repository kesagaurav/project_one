package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;

public interface OrderService {
	public int AddProductToOrder(Cart cart) throws BusinessException;
	
}
