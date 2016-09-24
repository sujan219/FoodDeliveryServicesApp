package cs544.fooddelivery.customer;

import java.util.List;

import cs544.fooddelivery.domain.Consumer;
import cs544.fooddelivery.domain.Order;

public interface ICustomerService {
	
	Consumer update(Consumer customer);
	List<Order> orders();
	List<Order> orderHistory();

}
