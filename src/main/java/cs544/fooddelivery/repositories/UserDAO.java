package cs544.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.fooddelivery.domain.User;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public interface UserDAO extends JpaRepository<User, Integer>{
	public User findOneByUserName(String userName);
}