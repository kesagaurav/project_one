package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CustomerDao;
//import com.gauravshopping.dbutil.MySqlConnection;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.util.MySqlConnection;

public class CustomerDaoImpl implements CustomerDao {
	private static Logger log=Logger.getLogger(CustomerDaoImpl.class);
	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c1=0;
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="insert into customer(customer_id,firstname,lastname,email,password)values(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,customer.getCustomer_id());
			preparedStatement.setString(2,customer.getFirst_name());
			preparedStatement.setString(3,customer.getLast_name());
			preparedStatement.setString(4,customer.getEmail());
			preparedStatement.setString(5,customer.getPassword());
			c1=preparedStatement.executeUpdate();
			log.info("\n successfully inserted  in the database " + c1);
		
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("\n invalid details please contact to the system admin they will reach you out");
		}
		return c1;
	}
	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customerList=new ArrayList<>();
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select customer_id,firstname,lastname,email,password from customer";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Customer customer=new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("firstname"));
				customer.setLast_name(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			}
			if(customerList.size()==0) {
				log.warn("no items where matched please conatct to system admin");
			}
		} catch (ClassNotFoundException | SQLException e) {
		log.warn(e.getMessage());
		}
		return customerList;
	}

}
