package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.EmployeeLoginCredentialsDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Employee;
import com.gauravshopping.util.MySqlConnection;

public class EmployeeCredentialsDaoImpl implements EmployeeLoginCredentialsDao {
	private static Logger log=Logger.getLogger(EmployeeCredentialsDaoImpl.class);

	@Override
	public int addEmployeeCredentials(String username, String password) throws BusinessException {
		
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select employee_name,employee_password from employee where employee_name=? and employee_password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Employee employee=new Employee();
				employee.setEmployee_name(resultset.getString("employee_name"));
				employee.setEmployee_pasword(resultset.getString("employee_password"));
				
			}
			log.info("employee successfully login");
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
		return 0;
		
		

		
	}

}
