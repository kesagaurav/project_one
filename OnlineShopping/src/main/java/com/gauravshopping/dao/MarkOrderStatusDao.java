package com.gauravshopping.dao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;

public interface MarkOrderStatusDao {

	public int markOrderStatus(Order order) throws BusinessException;
}
