package com.gauravshopping.service;

import java.util.List;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface ViewOrderService {

	public List<Order> getAllOrders() throws BusinessException;
}
