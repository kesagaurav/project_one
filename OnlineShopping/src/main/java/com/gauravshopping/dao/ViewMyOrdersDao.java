package com.gauravshopping.dao;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface ViewMyOrdersDao {

	public List<Order> getAllOrders() throws BusinessException;
	
}
