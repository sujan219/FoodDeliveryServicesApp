package cs544.fooddelivery.usermgmt;

import cs544.fooddelivery.domain.Consumer;
import cs544.fooddelivery.domain.Supplier;
import cs544.fooddelivery.domain.User;

public class UserMediator extends User {
	private double deliveryRadius;
	private String userType;
	
	public User getDomainUser(){
		User user = null;
		if(userType.equals("supplier")){
			user = new Supplier(getUserName(), getPassword(), getFullName(), getAddress(), getEmail(), getContact(), true, deliveryRadius);
		}else{
			user = new Consumer(getUserName(), getPassword(), getFullName(), getAddress(), getEmail(), getContact(), true);
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
