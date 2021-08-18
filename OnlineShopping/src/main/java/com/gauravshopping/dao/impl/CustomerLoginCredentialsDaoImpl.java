package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CustomerLoginCredentialsDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.util.MySqlConnection;

public class CustomerLoginCredentialsDaoImpl implements CustomerLoginCredentialsDao {
	private static Logger log=Logger.getLogger(CustomerLoginCredentialsDaoImpl.class);
	@Override
	public String addCredentials(String email, String password) throws BusinessException {
		//int b=0;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select email,password from customer where email=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer c=new Customer();
				c.setEmail(resultSet.getString("email"));
				c.setPassword(resultSet.getString("password"));
			
			}
		
			log.info("successfully logged in");
			
		} catch (ClassNotFoundException | SQLException e) {
				log.warn(e.getMessage());
		}
		//return 1;
		//return email + password;
		return "";
		
	}

}
