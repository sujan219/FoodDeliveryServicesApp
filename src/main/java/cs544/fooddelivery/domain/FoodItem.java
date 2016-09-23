package cs544.fooddelivery.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class FoodItem {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private Date expiryDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Supplier supplier;
}