package com.gauravshopping.service;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;

public interface CartService {
	public int addProduct(Cart cart) throws BusinessException;
	public List<Cart> getAllCartDetails(int product_id) throws BusinessException;
}
