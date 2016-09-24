package cs544.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.fooddelivery.domain.Consumer;


@Repository("goalRepository")
public interface CustomerDAO extends JpaRepository<Consumer, Long>{

}
