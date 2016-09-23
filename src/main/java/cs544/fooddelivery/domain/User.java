package cs544.fooddelivery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class User {
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private String address;
	private String email;
	private String contact;
	private boolean isActive;
}