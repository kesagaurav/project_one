package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		try(Connection con=MySqlConnection.getConnection()){
			String sql="insert into customer(customer_id,firstname,lastname,email,password,product_id)values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,customer.getCustomer_id());
			ps.setString(2,customer.getFirst_name());
			ps.setString(3,customer.getLast_name());
			ps.setString(4,customer.getEmail());
			ps.setString(5,customer.getPassword());
			ps.setInt(6, customer.getProduct().getProduct_id());
			c1=ps.executeUpdate();
			log.info("\n successfully inserted  in the database " + c1);
		
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("\n invalid details please contact to the system admin they will reach you out");
		}
		return c1;
	}

}
