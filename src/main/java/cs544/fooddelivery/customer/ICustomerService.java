package cs544.fooddelivery.customer;

import java.util.List;

import cs544.fooddelivery.domain.Customer;
import cs544.fooddelivery.domain.Order;

public interface ICustomerService {
	
	Customer update(Customer customer);
	List<Order> orders();
	List<Order> orderHistory();

}
