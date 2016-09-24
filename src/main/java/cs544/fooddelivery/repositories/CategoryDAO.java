package cs544.fooddelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cs544.fooddelivery.domain.Category;

public interface CategoryDAO extends JpaRepository<Category, Long>  {
	
}
