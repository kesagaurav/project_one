package com.gauravshopping.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Customer;
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

		do {
			log.info("1) employee login");
			log.info("2) customer login");
			log.info("3) register an customer");
			log.info("4)  exit");
			try {
				ch = Integer.parseInt((sc.nextLine()));
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				log.info("\n adding new products please wait");
				break;
			case 2:
				log.info("\n adding new products please wait");
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
						log.info("\n custmer is registered successfully");
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
