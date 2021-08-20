package com.gauravshopping.model;

public class Cart {

	private int cart_id;
	private Product product;
	private int customerid;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cart_id, Product product, int customerid) {
		super();
		this.cart_id = cart_id;
		this.product = product;
		this.customerid = customerid;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product=" + product + ", customerid=" + customerid + "]";
	}
	
	
	
	
}
