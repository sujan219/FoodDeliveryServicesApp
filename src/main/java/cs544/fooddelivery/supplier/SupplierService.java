package cs544.fooddelivery.supplier;

import java.util.List;

//package cs544.fooddelivery.usermgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.fooddelivery.domain.Category;
import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.repositories.CategoryDAO;
import cs544.fooddelivery.repositories.FoodItemDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class SupplierService {
	
	@Autowired
	private FoodItemDAO foodItemDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public Category getCategoryWithCategoryId(Long categoryId){
		return this.categoryDAO.findOne(categoryId);
	}
	
	public List<Category> getAllCategories(){
		return this.categoryDAO.findAll();
	}
	
	public List<FoodItem> getAllFoodItems(){
		return this.foodItemDAO.findAll();
	}
	
	public void deleteFoodItemForId(Long foodItemId){
		this.foodItemDAO.delete(foodItemId);
	}
	
	public FoodItem getFoodItemForId(Long foodItemId){
		return this.foodItemDAO.findOne(foodItemId);
	}
	
	public void saveFoodItem(FoodItem fitem){
		this.foodItemDAO.save(fitem);
	}

	public void setFoodItemDAO(FoodItemDAO foodItemDAO) {
		this.foodItemDAO = foodItemDAO;
	}
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
