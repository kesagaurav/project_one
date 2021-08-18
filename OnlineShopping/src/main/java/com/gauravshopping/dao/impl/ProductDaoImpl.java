package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.ProductDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;
//import com.gauravshopping.product.dao.ProductDao;
import com.gauravshopping.util.MySqlConnection;

//import jdk.internal.org.jline.utils.Log;

public class ProductDaoImpl implements ProductDao {
	private static Logger log=Logger.getLogger(ProductDaoImpl.class);
	@Override
	public int CreateProduct(Product p) throws BusinessException {

		int c = 0;
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "insert into product(product_id,product_name,price) values(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, p.getProduct_id());
			preparedStatement.setString(2, p.getProduct_name());
			preparedStatement.setFloat(3, p.getPrice());
			c=preparedStatement.executeUpdate();
			log.info("succesfully inserted " + c);

		} catch (ClassNotFoundException | SQLException e) {
			log.warn("deos not inserted succesfully please contact to system admin");
		}

		return c;
	}

	@Override
	public int updateProduct(int id, float price) throws BusinessException {
		int c = 0;
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "update from product set price=? where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			preparedStatement.setFloat(2,price);
		
			c=preparedStatement.executeUpdate();
			log.info("succesfully updated" + c);

		} catch (ClassNotFoundException | SQLException e) {
			log.warn("deos not inserted succesfully please contact to system admin");
		}

		return c;

		
		
	}

}
