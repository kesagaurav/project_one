package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.ViewMyOrdersDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Order;
import com.gauravshopping.model.Product;
import com.gauravshopping.util.MySqlConnection;

public class MyOrderDaoImpl implements ViewMyOrdersDao{
	private static Logger log=Logger.getLogger(OrderDaoImpl.class);
	
	@Override
	public List<Order> getAllOrders() throws BusinessException {
		List<Order> orderList=new ArrayList<>();
	
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select order_id,customer_id,status, o.product_id product_id,product_name,price from onlineshopping.order o join onlineshopping.product p on o.product_id=p.product_id where o.customer_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerLoginCredentialsDaoImpl.ad);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order=new Order();
				order.setOrder_id(resultSet.getInt(1));
				order.setCustomer_id(resultSet.getInt(2));
				
				order.setStatus(resultSet.getString(3));
				
				Product product=new Product();
				product.setProduct_id(resultSet.getInt(4));
				product.setProduct_name(resultSet.getString(5));
				product.setPrice(resultSet.getFloat(6));
				order.setProduct(product);
				orderList.add(order);
				
			}
			if(orderList.size()==0) {
				log.warn("no orders placed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return orderList;
	}

}
