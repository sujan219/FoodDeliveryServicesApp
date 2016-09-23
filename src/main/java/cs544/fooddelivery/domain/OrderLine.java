package cs544.fooddelivery.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class OrderLine {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	
	@ManyToOne
	private Order order;
	
	private FoodItem foodItem;
}