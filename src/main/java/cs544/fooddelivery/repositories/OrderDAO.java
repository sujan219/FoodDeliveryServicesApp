package cs544.fooddelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.fooddelivery.domain.Order;
//@Query("FROM OrderLine")
//

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public interface OrderDAO extends JpaRepository<Order, Long>  {

	//SELECT s FROM Schedule as s LEFT JOIN s.reservations as r WHERE 
	//(r.resDate is null or r.resDate = :planningDate) order by s.startHour
	@Query("select distinct ol.order FROM OrderLine as ol JOIN ol.foodItem as f WHERE f.supplier.id= ?1 ")
    public List<Order> findAllOrdersForSupplier(Long supplierId);
}