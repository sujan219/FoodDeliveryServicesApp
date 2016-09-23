package cs544.fooddelivery.domain;

import java.util.List;

import javax.persistence.OneToMany;

public class Consumer extends User {
	@OneToMany(mappedBy="consumer")
	private List<Order> orders;
}
