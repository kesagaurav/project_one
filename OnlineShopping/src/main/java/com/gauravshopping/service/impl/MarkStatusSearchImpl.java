package com.gauravshopping.service.impl;

import com.gauravshopping.dao.MarkOrderStatusDao;
import com.gauravshopping.dao.impl.MarkOrderStatusDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;
import com.gauravshopping.service.MarkStatusService;

public class MarkStatusSearchImpl implements MarkStatusService {
private MarkOrderStatusDao markOrdersDao=new MarkOrderStatusDaoImpl();
	@Override
	public int markOrderStatus(Order order) throws BusinessException {
		// TODO Auto-generated method stub
		return markOrdersDao.markOrderStatus(order);
	}

}
