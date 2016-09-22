package cs544.fooddelivery.system.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private Date orderDate;
	private Date expectedDeliveryDate;
	private Date deliveryDate;
	private List<OrderLine> orderLines;
	private Consumer consumer;
}