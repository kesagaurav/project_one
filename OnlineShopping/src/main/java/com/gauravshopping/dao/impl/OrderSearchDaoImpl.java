package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gauravshopping.dao.OrderSearchDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Order;
import com.gauravshopping.util.MySqlConnection;

public class OrderSearchDaoImpl implements OrderSearchDao {

	@Override
	public Order getOrderById(int order_id) throws BusinessException {
		Order order=null;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select order_id,o.customer_id customer_id,firstname,lastname,product_id  from onlineshopping.order o join customer c on o.customer_id=c.customer_id where o.order_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,order_id);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				 order=new Order();
				 order.setOrder_id(order_id);
				 order.setCustomer_id(resultset.getInt("customer_id"));
				 //order.getProduct().setProduct_id(resultset.getInt("product_id"));
				 Customer customer=new Customer();
				 customer.setCustomer_id(resultset.getInt("customer_id"));
				 customer.setFirst_name(resultset.getString("firstname"));
				 customer.setLast_name(resultset.getString("lastname"));
				 customer.setPassword(resultset.getString("password"));
				 customer.setEmail(resultset.getString("email"));
				 
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("invalid please conatct to system admin");
		}
	
		return order;
	}

}
