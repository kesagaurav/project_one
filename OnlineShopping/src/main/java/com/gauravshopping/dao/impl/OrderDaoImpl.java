package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.OrderDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;
import com.gauravshopping.util.MySqlConnection;

public class OrderDaoImpl implements OrderDao {
	private static Logger log=Logger.getLogger(OrderDaoImpl.class);
	@Override
	public int AddProductToOrder(Cart cart) throws BusinessException {
		int d=0;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="insert into onlineshopping.order(customer_id,product_id) select customer_id,product_id from cart where customer_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerLoginCredentialsDaoImpl.ad);
			preparedStatement.executeUpdate();
			String sql2="delete from cart where customer_id=?";
			PreparedStatement preparedStatement1=connection.prepareStatement(sql2);
			preparedStatement1.setInt(1, cart.getCustomerid());
			d=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return d;
	}

}
