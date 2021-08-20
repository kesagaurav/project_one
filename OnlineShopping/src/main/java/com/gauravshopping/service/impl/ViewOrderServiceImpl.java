package com.gauravshopping.service.impl;

import java.util.List;

import com.gauravshopping.dao.ViewMyOrdersDao;
import com.gauravshopping.dao.impl.MyOrderDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;
import com.gauravshopping.service.ViewOrderService;

public class ViewOrderServiceImpl implements ViewOrderService {
	ViewMyOrdersDao viewOrderDao=new MyOrderDaoImpl();

	@Override
	public List<Order> getAllOrders() throws BusinessException {
		return viewOrderDao.getAllOrders();
	}
	
}
