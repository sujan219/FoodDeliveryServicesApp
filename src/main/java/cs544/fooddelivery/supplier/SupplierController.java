package cs544.fooddelivery.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.fooddelivery.domain.Category;
import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.domain.Supplier;
import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.repositories.CategoryDAO;
import cs544.fooddelivery.repositories.FoodItemDAO;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
public class SupplierController {
	
	@Autowired
	FoodItemDAO foodItemDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	UserMgmtService loggedInUser;
	
	@RequestMapping("/supplier")
	public String displaySupplierDashboard(){
		
//		FoodItem f=new FoodItem();
//		f.setName("pizza");
//		this.supplierRepo.save(f);
		
		return "supplier";
	}
	
	@RequestMapping(value="/supplier/manageFoodItem/add", method=RequestMethod.POST)
	public String addFoodItem(@RequestParam Long categoryId,@RequestParam String foodItemName,@RequestParam String foodItemDesc){
		
		FoodItem fi=new FoodItem();
		fi.setCategory(this.categoryDAO.findOne(categoryId));
		fi.setName(foodItemName);
		fi.setDescription(foodItemDesc);
		fi.setSupplier((Supplier)this.loggedInUser.getLoggedInUser());
		this.foodItemDAO.save(fi);

		return "redirect:/supplier/manageFoodItem?";
	}
	
	@RequestMapping("/supplier/manageFoodItem/add")
	public String foodItemAdd(ModelMap model){
		model.addAttribute("categories", this.categoryDAO.findAll());
		return "addFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem/edit/{foodItemId}")
	public String foodITemEdit(ModelMap model,@PathVariable("foodItemId") Long foodItemId){
		model.addAttribute("editItem", this.foodItemDAO.findOne(foodItemId));
		model.addAttribute("categories", this.categoryDAO.findAll());
		return "addFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem/delete/{foodItemId}")
	public String foodItemDelete(@PathVariable("foodItemId") Long foodItemId){
		this.foodItemDAO.delete(foodItemId);
		return "redirect:/supplier/manageFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem")
	public String manageFoodItem(ModelMap model){
		model.addAttribute("foodItems", this.foodItemDAO.findAll());
		return "manageFoodItem";
	}
}
