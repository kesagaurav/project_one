package com.gauravshopping.service.impl;

import java.util.List;

import com.gauravshopping.dao.CartDao;
import com.gauravshopping.dao.impl.CartDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;
import com.gauravshopping.service.CartService;

public class CartServiceImpl implements CartService {

	private CartDao cartDao=new CartDaoImpl();
	
	@Override
	public int addProduct(Cart cart) throws BusinessException {
		return cartDao.addProduct(cart);
	}

	@Override
	public List<Cart> getAllCartDetails(Cart cart) throws BusinessException {
		// TODO Auto-generated method stub
		return cartDao.getAllCartDetails(cart);
	}

}
