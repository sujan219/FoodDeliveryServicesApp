package cs544.fooddelivery.usermgmt;

import cs544.fooddelivery.domain.Customer;
import cs544.fooddelivery.domain.Supplier;
import cs544.fooddelivery.domain.User;

public class UserProxy extends User {
	private double deliveryRadius;
	private String userType;
	
	public UserProxy(){}
	
	public UserProxy(Supplier supplier){
		//super(supplier.getUserName(), supplier.getPassword(), supplier.getFullName());
	}
	
	public UserProxy(Customer customer){
		
	}
	
	public User getDomainUser(){
		User user = null;
		if(userType.equals("supplier")){
			user = new Supplier(getUserName(), getPassword(), getFullName(), getAddress(), getEmail(), getContact(), true, deliveryRadius);
		}else{
			user = new Customer(getUserName(), getPassword(), getFullName(), getAddress(), getEmail(), getContact(), true);
		}
		return user;
	}

	public double getDeliveryRadius() {
		return deliveryRadius;
	}

	public void setDeliveryRadius(double deliveryRadius) {
		this.deliveryRadius = deliveryRadius;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
