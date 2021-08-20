package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.MarkOrderStatusDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;
import com.gauravshopping.util.MySqlConnection;

public class MarkOrderStatusDaoImpl implements MarkOrderStatusDao {
	private static Logger log=Logger.getLogger(MarkOrderStatusDaoImpl.class);
	@Override
	public int markOrderStatus(Order order) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="update onlineshopping.order set status='received' where customer_id=? and order_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,CustomerLoginCredentialsDaoImpl.ad);
			preparedStatement.setInt(2, order.getOrder_id());
			c=preparedStatement.executeUpdate();
			log.info("successfully updated " + 1);
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("please conatct system admin");
		}
		return c;
	}

}
