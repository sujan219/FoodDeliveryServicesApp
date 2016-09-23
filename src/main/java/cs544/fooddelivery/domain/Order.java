package cs544.fooddelivery.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private int id;
	
	private Date orderDate;
	private Date expectedDeliveryDate;
	private Date deliveryDate;
	
	@OneToMany(mappedBy="order")
	private List<OrderLine> orderLines;
	
	@ManyToOne
	private Consumer consumer;
	
	@ManyToOne
	private Delivery delivery;
}