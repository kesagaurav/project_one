package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CustomerProductDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.util.MySqlConnection;

public class CustomerProductDaoImpl implements CustomerProductDao {
	private static Logger log = Logger.getLogger(CustomerProductDaoImpl.class);

	@Override
	public int addProduct(Customer c) throws BusinessException {
		int c1 = 0;
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "insert into customer(fisrtname,product_id)values(?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, c.getFirst_name());
			preparedStatement.setInt(2, c.getProduct().getProduct_id());
			c1 = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}

		return c1;

	}
}
