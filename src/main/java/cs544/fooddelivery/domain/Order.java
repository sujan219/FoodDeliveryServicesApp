package cs544.fooddelivery.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "OrderTable")
public class Order {
	@Id
	@GeneratedValue
	private Long id;

	private Date orderDate;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderLine> orderLines;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Delivery delivery;

	@Enumerated(EnumType.STRING)
	private Status status;

	private Double totalPrice;

	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	// methods
	public double getTotalPrice() {
		

		for (OrderLine ol : this.orderLines) {
			this.totalPrice += ol.getTotalPrice();
		}

		return this.totalPrice;
	}
}