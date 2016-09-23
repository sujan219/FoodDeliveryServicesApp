package cs544.fooddelivery.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Delivery {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	
	@OneToMany(mappedBy="delivery")
	private List<Order> orders;
}
