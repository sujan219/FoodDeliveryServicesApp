package cs544.fooddelivery.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ROLE_CONSUMER")
public class Consumer extends User {
	@OneToMany(mappedBy="consumer")
	private List<Order> orders;
}
