package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface OrderSearchService {
	public Order getOrderById(int order_id) throws BusinessException;
}
