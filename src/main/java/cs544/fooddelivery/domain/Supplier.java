package cs544.fooddelivery.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ROLE_SUPPLIER")
public class Supplier extends User {
	private double deliveryRadius;
	
	@OneToMany(mappedBy="supplier")
	private List<FoodItem> foodItems;
}
