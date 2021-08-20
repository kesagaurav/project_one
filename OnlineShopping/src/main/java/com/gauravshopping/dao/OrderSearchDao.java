package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface OrderSearchDao {

	public Order getOrderById(int order_id) throws BusinessException;
	
}
