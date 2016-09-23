package cs544.fooddelivery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private FoodItem foodItem;
}