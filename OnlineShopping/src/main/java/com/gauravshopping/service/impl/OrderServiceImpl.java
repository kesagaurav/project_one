package com.gauravshopping.service.impl;

import com.gauravshopping.dao.OrderDao;
import com.gauravshopping.dao.impl.OrderDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;
import com.gauravshopping.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao=new OrderDaoImpl();
	@Override
	public int AddProductToOrder(Cart cart) throws BusinessException {
		
		return orderDao.AddProductToOrder(cart);
	}

}
