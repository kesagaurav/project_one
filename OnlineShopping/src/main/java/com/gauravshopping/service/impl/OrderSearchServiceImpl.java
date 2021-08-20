package com.gauravshopping.service.impl;

import com.gauravshopping.dao.OrderSearchDao;
import com.gauravshopping.dao.impl.OrderSearchDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;
import com.gauravshopping.service.OrderSearchService;

public class OrderSearchServiceImpl implements OrderSearchService {
private OrderSearchDao orderSearchDao=new OrderSearchDaoImpl();
	@Override
	public Order getOrderById(int order_id) throws BusinessException {
		// TODO Auto-generated method stub
		return orderSearchDao.getOrderById(order_id);
	}

}
