package com.gauravshopping.model;

public class Cart {

	private int cart_id;
	private Product product;
	private Customer customer;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cart_id, Product product, Customer customer) {
		super();
		this.cart_id = cart_id;
		this.product = product;
		this.customer = customer;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", product=" + product + ",customer = " + customer + "]";
	}
	
	
	
	
}
