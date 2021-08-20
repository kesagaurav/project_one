package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CustomerLoginCredentialsDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.util.MySqlConnection;

public class CustomerLoginCredentialsDaoImpl implements CustomerLoginCredentialsDao {
	private static Logger log=Logger.getLogger(CustomerLoginCredentialsDaoImpl.class);
	public static int ad;
	@Override
	public String addCredentials(String email, String password) throws BusinessException {
		boolean   result = false;
	
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select customer_id,email,password from customer where email=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
		
			while(resultSet.next()) {
//				Customer customer=new Customer();
//				customer.setEmail(resultSet.getString("email"));
//				customer.setPassword(resultSet.getString("password"));
				ad=resultSet.getInt(1);
				result=true;
			
			}
		
			log.info("successfully logged in");
			
		} catch (ClassNotFoundException | SQLException e) {
				log.warn(e.getMessage());
		}
	
		return "";
		
	}

}
