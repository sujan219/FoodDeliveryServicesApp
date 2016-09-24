package cs544.fooddelivery.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cs544.fooddelivery.domain.Category;
import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.repositories.CategoryDAO;
import cs544.fooddelivery.repositories.FoodItemDAO;

@Controller
public class SupplierController {
	
	@Autowired
	FoodItemDAO foodItemDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/supplier")
	public String displaySupplierDashboard(){
		
//		FoodItem f=new FoodItem();
//		f.setName("pizza");
//		this.supplierRepo.save(f);
		
		return "supplier";
	}
	
	@RequestMapping("/supplier/manageFoodItem/add")
	public String displaySupplierDashboard1(){
		
//		this.foodItemDAO.findAll();
		
		for(Category f:this.categoryDAO.findAll()){
			System.out.println("CategoryName:"+f.getName());
		}
		
		return "addFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem")
	public String manageFoodItem(){
		return "manageFoodItem";
	}
}
