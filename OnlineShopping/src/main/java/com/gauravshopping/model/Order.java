package com.gauravshopping.model;

public class Order {

	private int order_id;
	private Product product;
	private int customer_id;
	private String status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int order_id, Product product, int customer_id, String status) {
		super();
		this.order_id = order_id;
		this.product = product;
		this.customer_id = customer_id;
		this.status = status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", product=" + product + ", customer_id=" + customer_id + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
