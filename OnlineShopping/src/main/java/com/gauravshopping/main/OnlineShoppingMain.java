package com.gauravshopping.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.gauravshopping.dao.impl.CustomerLoginCredentialsDaoImpl;
import com.gauravshopping.exception.BusinessException;
import com.gauravshopping.model.Cart;
import com.gauravshopping.model.Customer;
import com.gauravshopping.model.Order;
import com.gauravshopping.model.Product;
import com.gauravshopping.service.CartService;
import com.gauravshopping.service.CustomerSearchService;
import com.gauravshopping.service.CustomerService;
import com.gauravshopping.service.LoginCustomerService;
import com.gauravshopping.service.LoginEmployeeService;
import com.gauravshopping.service.MarkStatusService;
import com.gauravshopping.service.OrderSearchService;
import com.gauravshopping.service.OrderService;
import com.gauravshopping.service.ProductDaoService;
import com.gauravshopping.service.ViewOrderService;
import com.gauravshopping.service.impl.CartServiceImpl;
import com.gauravshopping.service.impl.CustomerSearchServiceImpl;
import com.gauravshopping.service.impl.CustomerServiceImpl;
import com.gauravshopping.service.impl.EmployeeLoginServiceImpl;
import com.gauravshopping.service.impl.LoginCustomerServiceImpl;
import com.gauravshopping.service.impl.MarkStatusSearchImpl;
import com.gauravshopping.service.impl.OrderSearchServiceImpl;
import com.gauravshopping.service.impl.OrderServiceImpl;
import com.gauravshopping.service.impl.ProductServiceImpl;
import com.gauravshopping.service.impl.ViewOrderServiceImpl;

public class OnlineShoppingMain {
	private static Logger log = Logger.getLogger(OnlineShoppingMain.class);

	public static void main(String[] args) {
		log.info(
				"\n Hi welcome to the menu driven app for online shopping we have new products and good quantity also the quality asurance as well");
		log.info("========================================================");
		Scanner scan = new Scanner(System.in);
		int ch = 0;
		ProductDaoService productService = new ProductServiceImpl();

		CustomerService customerService = new CustomerServiceImpl();
		CartService cartService = new CartServiceImpl();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		ViewOrderService viewOrderService = new ViewOrderServiceImpl();
		MarkStatusService markStatusService=new MarkStatusSearchImpl();
		OrderSearchService 	orderSearchService=new OrderSearchServiceImpl();

		do {
			log.info("1) employee login");
			log.info("2) customer login");
			log.info("3) register an customer");
			log.info("4)  exit");
			try {
				ch = Integer.parseInt((scan.nextLine()));
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
			}
			switch (ch) {
			case 1:
				log.info("\n please add the below details for the employee login");
				LoginEmployeeService loginEmployeeService = new EmployeeLoginServiceImpl();
				try {
					log.info("please enter username");
					String username = scan.nextLine();
					log.info("please enter password");
					String password = scan.nextLine();
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
					option1 = Integer.parseInt(scan.nextLine());
					switch (option1) {
					case 1:

						Product product = new Product();
						log.info("here are the details for adding the product");
						log.info("please enter product id");
						product.setProduct_id(Integer.parseInt(scan.nextLine()));
						log.info("please enter product name");
						product.setProduct_name(scan.nextLine());
						log.info("enter price");
						product.setPrice(Float.parseFloat(scan.nextLine()));
						try {
							if (productService.CreateProduct(product) == 1) {
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
						int id = Integer.parseInt(scan.nextLine());
						log.info("please enter price");
						float price = Float.parseFloat(scan.nextLine());
						try {
							productService.updateProduct(id, price);
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
				LoginCustomerService loginCustomerService = new LoginCustomerServiceImpl();
				try {
					log.info("please enter username");
					String email = scan.nextLine();
					log.info("please enter password");
					String password = scan.nextLine();
					log.info(loginCustomerService.addCredentials(email, password));
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				log.info("welcome to the gaurav online shopping what products you want to buy");

				int option = 0;
				do {
					log.info("here is the product serach based upon there fields");
					log.info("1)product_name");
					log.info("2) shows the customers with product price");
					log.info("3) Add Product to Cart");
					log.info("4)view cart");
					log.info("5)place an order");
					log.info("6) view all my order and status");
					log.info("7)search the customer with varies fields");
					log.info("8)mark the status has received");
					log.info("9)exit from the product");
					option = Integer.parseInt(scan.nextLine());
					switch (option) {
					case 1:
						log.info("\n please enter the following details");
						log.info("please enter product name");
						String name = scan.nextLine();
						try {
							List<Product> productList = productService.getProductByProductName(name);
							if (productList != null && productList.size() > 0) {
								log.info("Total there are " + productList.size() + " number of products name is "
										+ name.toUpperCase() + "pinting products names");
								for (Product p1 : productList) {
									log.info(p1);
								}
							}
						} catch (BusinessException e1) {
							log.warn(e1.getMessage());
						}
						break;
					case 2:
						log.info("\n you can view the products");
						try {
							log.info(productService.getAllProducts());
						} catch (BusinessException e) {
							log.info(e.getMessage());
						}

						break;
					case 3:
						log.info("\n please enter the below details to get the product from the cart");
						Cart cart = new Cart();

						log.info("please select the product from below details");

						try {
							List<Product> productList = productService.getAllProducts();
							for (int i = 0; i < productList.size(); i++) {
								log.info((i + 1) + ")" + productList.get(i).getProduct_name());
							}
							log.info(productList.size() + 1 + ")" + "not preffered for now ");
							try {
								log.info("please enter your product id with below details -" + productList.size());
								int option11 = Integer.parseInt(scan.nextLine());
								if (option11 > 0 && option11 <= productList.size() + 1) {
									if (option11 == productList.size() + 1) {
										cart.setProduct(new Product());
									} else {
										cart.setProduct(productList.get(option11 - 1));
									}

								} else {
									log.warn("invalid choice");
								}
							} catch (NumberFormatException e) {
								log.warn(e.getMessage());
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
							break;
						}

						try {

							if (cartService.addProduct(cart) == 1) {
								log.info("successfully added to the cart");

							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
							break;
						}

						break;
					case 4:
						log.info("\n viewing the cart");
						try {
							Cart cart1 = new Cart();
							cart1.setCustomerid(CustomerLoginCredentialsDaoImpl.ad);
							List<Cart> productList = cartService.getAllCartDetails(cart1);
							double total = 0;
							for (Cart i : productList) {
								total = productList.stream().mapToDouble(i1 -> i1.getProduct().getPrice()).sum();
								log.info(i);
							}
							log.info("total price is " + total);

						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 5:
						Cart cart4=new Cart();
						try {
							log.info(cartService.getAllCartDetails(cart4));
						} catch (BusinessException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						//OrderService orderService=new OrderServiceImpl();
						try {
							Cart cart3 = new Cart();
							if (orderService.AddProductToOrder(cart3) == 1) {
								log.info("sucessfully ordered");

							}

						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}

						break;
					case 6:
						log.info("below these are the order and my status");
						Order order = new Order();
						order.setCustomer_id(CustomerLoginCredentialsDaoImpl.ad);
						try {
							List<Order> orderList = viewOrderService.getAllOrders();
							for (Order o : orderList) {
								log.info(o);
							}
						} catch (BusinessException e1) {
							log.warn(e1.getMessage());
						}

						break;
					case 7:
						log.info("\n here are the various filters for the customer fields");
						int option11 = 0;
						do {
							log.info("1)search based on the id");
							log.info("2)search based on firstname");
							log.info("3)search based upon the lastname");
							log.info("4)search based upon the email");
							log.info("5)search based on the order id");
							log.info("6)exit");
							try {
								option11 = Integer.parseInt(scan.nextLine());
							} catch (NumberFormatException e) {
							}

							switch (option11) {
							case 1:
								log.info("enter customer id with details");
								int customer_id = Integer.parseInt(scan.nextLine());
								try {
									Customer customer = customerSearchService.GetCustomerById(customer_id);
									if (customer != null) {
										log.info("custmer found with below details ");
										log.info(customer);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 2:
								log.info("enter customer first name with details");
								String firstname = scan.nextLine();
								List<Customer> customerList;
								try {
									customerList = customerSearchService.getStringByFirstName(firstname);
									if (customerList != null && customerList.size() > 0) {
										log.info("Total there are " + customerList.size());
										for (Customer customer1 : customerList) {
											log.info(customer1);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}

								break;
							case 3:
								log.info("enter customer lastname");
								String lastname = scan.nextLine();
								try {
									List<Customer> customerList1 = customerSearchService.getStringByLastName(lastname);
									for (Customer customer2 : customerList1) {
										log.info(customer2);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 4:
								log.info("enter customer email");
								String email = scan.nextLine();
								try {
									List<Customer> customerList2 = customerSearchService.getStringByEmail(email);
									for (Customer customer2 : customerList2) {
										log.info(customer2);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 5:
								log.info("enter order details");
							int order_id=Integer.parseInt(scan.nextLine());
								try {
									Order order1=orderSearchService.getOrderById(order_id);
									if(order1!=null) {
										log.info("order1 is found with " + order1);
										log.info(order1);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
							
								break;
							default:
								log.info("please enter your choice between (1-6) only");
								break;
							}
						} while (option11 != 6);
						break;
					case 8:
						log.info("\n please enter an order id");
						int oid=0;
						try {
							oid = Integer.parseInt(scan.nextLine());
						} catch (NumberFormatException e) {}
						try {
							Order order1=new Order();
							order1.setCustomer_id(CustomerLoginCredentialsDaoImpl.ad);
							order1.setOrder_id(oid);
							log.info("the changes has been updated");
							markStatusService.markOrderStatus(order1);
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						
						break;
					case 9:
						log.info("\n thankyou for using our app byeee ----------------- :)");
						break;
					default:
						log.info("please enter choice between (1-9) only ");
						break;
					}

				} while (option != 9);

				break;
			case 3:
				log.info("\n please register an customer with below details");
				Customer customer = new Customer();
				try {

					log.info("\n please enter an customer id");
				} catch (NumberFormatException e) {
					log.error(e.getMessage());
				}

				customer.setCustomer_id(Integer.parseInt(scan.nextLine()));
				log.info("\n please enter fisrtname");
				customer.setFirst_name(scan.nextLine());
				log.info("\n please enter lastname");
				customer.setLast_name(scan.nextLine());
				log.info("\n  please enter email");
				customer.setEmail(scan.nextLine());
				log.info("\n please enter password");
				customer.setPassword(scan.nextLine());

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
				log.info("\n you should  enter  your choice between 1 to 4 only");
				break;
			}
		} while (ch != 4);
		scan.close();
	}

}
