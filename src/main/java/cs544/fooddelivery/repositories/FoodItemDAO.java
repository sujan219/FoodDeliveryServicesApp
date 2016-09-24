package cs544.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.fooddelivery.domain.FoodItem;

public interface FoodItemDAO extends JpaRepository<FoodItem, Long>  {
	
}

//public interface ProjectDAO extends JpaRepository<Project, Long>{
//
//    Page<Project> findAll(Pageable pageable);
//
//    List<Project> findByProjectID(Integer projectID);
//
//}
