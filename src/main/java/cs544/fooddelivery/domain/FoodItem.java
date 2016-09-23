package cs544.fooddelivery.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
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
	
	@OneToMany
	private List<OrderLine> orderLines;
}