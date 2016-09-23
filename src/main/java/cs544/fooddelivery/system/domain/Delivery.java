package cs544.fooddelivery.system.domain;

import java.util.Date;
import java.util.List;

public class Delivery {
	private int id;
	private Date date;
	private List<OrderLine> orderLines;
}
