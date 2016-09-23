package cs544.fooddelivery.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_role")
public abstract class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	private String password;
	
	private String fullName;
	private String address;
	private String email;
	private String contact;
	private boolean isActive;
}