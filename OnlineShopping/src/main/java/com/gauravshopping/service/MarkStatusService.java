package com.gauravshopping.service;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface MarkStatusService {
	public int markOrderStatus(Order order) throws BusinessException;
}
