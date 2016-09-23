package cs544.fooddelivery.domain;

import java.util.List;

import javax.persistence.OneToMany;

public class Supplier extends User {
	private double deliveryRadius;
	
	@OneToMany(mappedBy="supplier")
	private List<FoodItem> foodItems;
}
