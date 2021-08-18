package com.gauravshopping.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.login.service.LoginCustomerService;
import com.gauravshopping.login.service.LoginEmployeeService;
import com.gauravshopping.login.service.impl.EmployeeLoginServiceImpl;
import com.gauravshopping.login.service.impl.LoginCustomerServiceImpl;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Employee;
import com.gauravshopping.model.Product;
import com.gauravshopping.product.service.ProductDaoService;
import com.gauravshopping.product.service.impl.ProductServiceImpl;
import com.gauravshopping.service.CustomerService;
import com.gauravshopping.service.impl.CustomerServiceImpl;

public class OnlineShoppingMain {
	private static Logger log = Logger.getLogger(OnlineShoppingMain.class);

	public static void main(String[] args) {
		log.info(
				"\n Hi welcome to the menu driven app for online shopping we have new products and good quantity also the quality asurance as well");
		log.info("========================================================");
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		ProductDaoService pDaoService=new ProductServiceImpl();

		do {
			log.info("1) employee login");
			log.info("2) customer login");
			log.info("3) register an customer");
			log.info("4)  exit");
			try {
				ch = Integer.parseInt((sc.nextLine()));
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
			}
			switch (ch) {
			case 1:
				log.info("\n please add the below details for the employee login");
				Employee employee = new Employee();
				LoginEmployeeService loginEmployeeService = new EmployeeLoginServiceImpl();
				try {
					log.info("please enter username");
					String username = sc.nextLine();
					log.info("please enter password");
					String password = sc.nextLine();
					log.info(loginEmployeeService.addEmployeeCredentials(username, password));
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				log.info("welcome to the employee database with products");
				int option1 = 0;
				do {
					log.info("1)add an product");
					log.info("2)update based on price");
					log.info("3)exit");
					option1 = Integer.parseInt(sc.nextLine());
					switch (option1) {
					case 1:
					
						Product product=new Product();
						log.info("here are the details for adding the product");
						log.info("please enter product id");
						product.setProduct_id(Integer.parseInt(sc.nextLine()));
						log.info("please enter product name");
						product.setProduct_name(sc.nextLine());
						log.info("enter price");
						product.setPrice(Float.parseFloat(sc.nextLine()));
						try {
							if(pDaoService.CreateProduct(product)==1) {
								log.info("successfully inserted the product");
								log.info(product);
							}
						} catch (BusinessException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						log.info("here are the details for updating price for particualr product name");
						log.info("enter the product id");
						int id=Integer.parseInt(sc.nextLine());
						log.info("please enter price");
						float price=Float.parseFloat(sc.nextLine());
						try {
							pDaoService.updateProduct(id, price);
						} catch (BusinessException e) {
							log.info(e.getMessage());
						}
						break;
					case 3:
						log.info("thankyou good bye and meet agin :)");
						break;

					default:
						log.info("thankyou for your patience");
						break;
					}
				} while (option1 != 3);
				break;
			case 2:
				log.info("\n hi please add the below details for the customer login");
				Customer customer1 = new Customer();
				LoginCustomerService loginCustomerService = new LoginCustomerServiceImpl();
				try {
					log.info("please enter username");
					String email = sc.nextLine();
					log.info("please enter password");
					String password = sc.nextLine();
					log.info(loginCustomerService.addCredentials(email, password));
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				log.info("welcome to the gaurav online shopping what products you want to buy");

				int option = 0;
				do {
					log.info("here is the product serach based upon there fields");
					log.info("1)product id");
					log.info("2)product_name");
					log.info("3)price");
					log.info("4)view cart");
					log.info("5)exit from the product");
					option = Integer.parseInt(sc.nextLine());
					switch (option) {
					case 1:
						log.info("\n adding some product please wait");
						break;
					case 2:
						log.info("\n adding some product please wait");
						break;
					case 3:
						log.info("\n adding some product please wait");
						break;
					case 4:
						log.info("\n adding some product please wait");
						break;
					case 5:
						log.info("\n thanks for using our app");
						break;

					default:
						log.info("please enter choice between (1-5) only ");
						break;
					}

				} while (option != 5);

				break;
			case 3:
				log.info("\n please register an customer with below details");
				CustomerService customerService = new CustomerServiceImpl();
				Customer customer = new Customer();
				try {

					log.info("\n please enter an customer id");
				} catch (NumberFormatException e) {
					log.error(e.getMessage());
				}

				customer.setCustomer_id(Integer.parseInt(sc.nextLine()));
				log.info("\n please enter fisrtname");
				customer.setFirst_name(sc.nextLine());
				log.info("\n please enter lastname");
				customer.setLast_name(sc.nextLine());
				log.info("\n  please enter email");
				customer.setEmail(sc.nextLine());
				log.info("\n please enter password");
				customer.setPassword(sc.nextLine());
				try {
					if (customerService.createCustomer(customer) == 1) {
						log.info("\n customer is registered successfully");
						log.info(customer);
					}
				} catch (BusinessException e) {
					log.info(e.getMessage());
				}
				break;
			case 4:
				log.info(
						"\n bye customers thanks for visting our app please visit again and give us feedback so that we can improve");
				break;
			default:
				log.info("\n plz enter choice between 1 to 4 only");
				break;
			}
		} while (ch != 4);

	}

}
