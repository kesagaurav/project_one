package com.gaurav.main;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Product;
import com.gauravshopping.service.CustomerSearchService;
import com.gauravshopping.service.CustomerService;
import com.gauravshopping.service.LoginCustomerService;
import com.gauravshopping.service.LoginEmployeeService;
import com.gauravshopping.service.ProductDaoService;
import com.gauravshopping.service.impl.CustomerSearchServiceImpl;
import com.gauravshopping.service.impl.CustomerServiceImpl;
import com.gauravshopping.service.impl.EmployeeLoginServiceImpl;
import com.gauravshopping.service.impl.LoginCustomerServiceImpl;
import com.gauravshopping.service.impl.ProductServiceImpl;

class TestCustomerService {
	
	private static CustomerService customerService;
	public static Customer cu1;
	private static LoginCustomerService loginCustomerService=new LoginCustomerServiceImpl();
	public static LoginEmployeeService loginEmployeeService=new EmployeeLoginServiceImpl();
	public static ProductDaoService productDaoService=new ProductServiceImpl();	
	public static List<Customer> customer;
	public static CustomerSearchService customerSerachservice;
	public static List<Product> product=new ArrayList<>();
	public static Product product1;
	
	@BeforeAll
	public static void setUp() throws Exception {
		customerService=new CustomerServiceImpl();
		
		customerSerachservice=new CustomerSearchServiceImpl();
		productDaoService=new ProductServiceImpl();
		product1=new Product(102,"lapotop",4000);
		
		
		
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void  testCreateCustomer() {
		int customer_id=53;
		String firstname="gaurav90";
		String lastname="kesa91";
		String email="kgr@gmail.com";
		String password="gat123771";
		cu1=new Customer(customer_id,firstname,lastname,email,password);
		int checkDetails=0;
		try {
		
		checkDetails=customerService.createCustomer(cu1);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	
		assertEquals(1,checkDetails);
		
	}
	@Test
	public void  testValidateCustomerCredentials() {
		String email="kesagaurav@gmail.com";
		String password="gaurav123456";
		try {
		assertEquals(true,loginCustomerService.addCredentials(email, password));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	@Test
	public void  testValidateEmployeeCredentials() throws BusinessException {
		String username="kesagaurav@yahoo.com";
		String password="gaurav123456";
		boolean result=true;
		assertEquals(result, loginEmployeeService.addEmployeeCredentials(username, password));
	}
	
	
	
	
	@Test
	public void testCustomerSearch() {
		String firstname="gaurav2";
		List<Customer> customerList=null;
		try {
			customerList=customerSerachservice.getStringByFirstName(firstname);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		assertEquals(1,customerList.size());
	}
	
	
	
	@Test
	public void testCustomerByEmail() {
		String email="kesagaurav@gmail.com";
		List<Customer> customerList=null;
		try {
			customerList=customerSerachservice.getStringByEmail(email);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		assertEquals(1,customerList.size());
	}
	
	
	@Test
	public void testCustomerByLastName() {
		String lastname="kesa3";
		List<Customer> customerList=null;
		try {
			customerList=customerSerachservice.getStringByLastName(lastname);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		assertEquals(1,customerList.size());
	}
	
	

	
	
	
	
	
	
	@Test
	public void testCreateProducts() {
		int product_id=108;
		String product_name="laptop";
		float price=300;
		try {
			product1=new Product(product_id,product_name,price);
			assertEquals(1,productDaoService.CreateProduct(product1));
		} catch (BusinessException e) {
		}
	}
	
	
	
	

}
