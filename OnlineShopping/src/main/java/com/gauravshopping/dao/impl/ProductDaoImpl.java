package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.ProductDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Product;
//import com.gauravshopping.product.dao.ProductDao;
import com.gauravshopping.util.MySqlConnection;

//import jdk.internal.org.jline.utils.Log;

public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);

	@Override
	public int CreateProduct(Product p) throws BusinessException {

		int c = 0;
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "insert into product(product_id,product_name,price) values(?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, p.getProduct_id());
			preparedStatement.setString(2, p.getProduct_name());
			preparedStatement.setFloat(3, p.getPrice());
			c = preparedStatement.executeUpdate();
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
			String sql = "update  product set price=? where product_id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setFloat(1, price);
			preparedStatement.setInt(2, id);

			c = preparedStatement.executeUpdate();
			log.info("succesfully updated " + c);

		} catch (ClassNotFoundException | SQLException e) {
			log.warn("deos not updated succesfully please contact to system admin");
		}

		return c;

	}

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "select product_id,product_name,price from product";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				productList.add(product);
			}
			if (productList.size() == 0) {
				log.warn("no products registered so far please add an anthor product");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return productList;

	}

	@Override
	public List<Product> getProductByProductName(String product_name) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection con = MySqlConnection.getConnection()) {
			String sql = "select product_id, product_name,price from product where product_name=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, product_name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				productList.add(product);

			}
			if(productList.size()==0)
				log.warn(" no product name " + product_name);
		} catch (ClassNotFoundException | SQLException e) {
		log.warn(e.getMessage());
		}
		return productList;
	}
}
