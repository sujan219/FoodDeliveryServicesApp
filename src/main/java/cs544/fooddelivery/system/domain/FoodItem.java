package cs544.fooddelivery.system.domain;

import java.util.Date;

public class FoodItem {
	private int id;
	private String name;
	private Date expiryDate;
	private int stockQuantity;
	private Category category;
	private Supplier supplier;
}