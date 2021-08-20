package com.gaurav.main;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;


import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
import com.gauravshopping.service.CustomerService;
import com.gauravshopping.service.LoginCustomerService;
import com.gauravshopping.service.LoginEmployeeService;
import com.gauravshopping.service.ProductDaoService;
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
	@BeforeAll
	public static void setUp() throws Exception {
		customerService=new CustomerServiceImpl();
		cu1=new Customer(30,"gaurav23","kesa23","kesagaurav@gmail.com","gaurav123456");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void  testCreateCustomer() {
		assertEquals(customerService, cu1);
	
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
	public void testGetAllCustomers() {
		try {
			assertEquals(true, customerService.createCustomer(cu1));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void  testValidateEmployeeCredentials() throws BusinessException {
		String username="kesagaurav@yahoo.com";
		String password="gaurav123456";
		assertEquals(1, loginEmployeeService.addEmployeeCredentials(username, password));
	}
	
	
	@Test
	public void testGetAllProducts() {
		try {
			assertEquals(true, productDaoService.getAllProducts());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
