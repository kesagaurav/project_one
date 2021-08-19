package com.gauravshopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gauravshopping.dao.CartDao;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;
import com.gauravshopping.model.Product;
import com.gauravshopping.util.MySqlConnection;

public class CartDaoImpl implements CartDao {
	private static Logger log=Logger.getLogger(CartDaoImpl.class);
	@Override
	public int addProduct(Cart cart) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlConnection.getConnection()){
		String sql="insert into cart(product_id,customer_id)values(?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, cart.getProduct().getProduct_id());
		preparedStatement.setInt(2, CustomerLoginCredentialsDaoImpl.ad);
		c=preparedStatement.executeUpdate();
		
	} catch (ClassNotFoundException | SQLException e) {
		log.warn(e.getMessage());
	}
		return c;

}
	@Override
	public List<Cart> getAllCartDetails(int product_id) throws BusinessException {
		List<Cart> cartList=new ArrayList<>();
		try(Connection connection=MySqlConnection.getConnection()){
			String sql="select p.product_id,product_name,price from product p join cart c on c.product_id=p.product_id where c.product_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, product_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product=new Product();
				product.setProduct_id(resultSet.getInt("product_id"));
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("price"));
				Cart cart=new Cart();
				cart.setCart_id(resultSet.getInt("cart_id"));
				cart.getProduct().setProduct_id(resultSet.getInt("product_id"));
				cart.getCustomer().setCustomer_id(resultSet.getInt("customer_id"));
				cart.setProduct(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cartList;
	}
	
}
