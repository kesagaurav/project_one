package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CustomerSearchDao;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Order;
import com.gauravshopping.util.MySqlConnection;

public class CustomerSearchDaoImpl implements CustomerSearchDao {
	private static Logger log = Logger.getLogger(CustomerSearchDaoImpl.class);

	@Override
	public Customer GetCustomerById(int customer_id) throws BusinessException {
		Customer customer = null;
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select customer_id,firstname,lastname,email,password from customer where customer_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("firstname"));
				customer.setLast_name(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));

			} else {
				log.warn("no id with this " + customer_id + "number");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return customer;
	}

	@Override
	public List<Customer> getStringByFirstName(String firstname) throws BusinessException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select customer_id,firstname,lastname,email,password from customer where firstname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstname);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("firstname"));
				customer.setLast_name(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			} else {
				log.warn("no name with this " + firstname + "name");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return customerList;
	}

	@Override
	public List<Customer> getStringByLastName(String lastname) throws BusinessException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select customer_id,firstname,lastname,email,password from customer where lastname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, lastname);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("firstname"));
				customer.setLast_name(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			} else {
				log.warn("no name with this " + lastname + "name");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return customerList;
	}

	@Override
	public List<Customer> getStringByEmail(String email) throws BusinessException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select customer_id,firstname,lastname,email,password from customer where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getInt("customer_id"));
				customer.setFirst_name(resultSet.getString("firstname"));
				customer.setLast_name(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				customerList.add(customer);
			} else {
				log.warn("no email with this " + email + "name");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
		}
		return customerList;
	}



}
