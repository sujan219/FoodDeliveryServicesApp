package cs544.fooddelivery.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.domain.Supplier;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	UserMgmtService userService;
	
	@RequestMapping("/supplier")
	public String displaySupplierDashboard(){
		return "supplier";
	}
	
	@RequestMapping(value="/supplier/manageFoodItem/add", method=RequestMethod.POST)
	public String addFoodItem(@RequestParam Long foodItemId,@RequestParam Long categoryId,@RequestParam String foodItemName,@RequestParam String foodItemDesc){
		
		FoodItem fi=new FoodItem();
		
		if(foodItemId!=null){
			fi.setId(foodItemId);
		}
		
		fi.setCategory(this.supplierService.getCategoryWithCategoryId(categoryId));
		fi.setName(foodItemName);
		fi.setDescription(foodItemDesc);
		fi.setSupplier((Supplier)this.userService.getLoggedInUser());
		this.supplierService.saveFoodItem(fi);

		return "redirect:/supplier/manageFoodItem?";
	}
	
	@RequestMapping("/supplier/manageFoodItem/add")
	public String foodItemAdd(ModelMap model){
		model.addAttribute("categories", this.supplierService.getAllCategories());
		return "addFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem/edit/{foodItemId}")
	public String foodITemEdit(ModelMap model,@PathVariable("foodItemId") Long foodItemId){
		model.addAttribute("categories", this.supplierService.getAllCategories());
		model.addAttribute("editItem", this.supplierService.getFoodItemForId(foodItemId));
		return "addFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem/delete/{foodItemId}")
	public String foodItemDelete(@PathVariable("foodItemId") Long foodItemId){
		this.supplierService.deleteFoodItemForId(foodItemId);
		return "redirect:/supplier/manageFoodItem";
	}
	
	@RequestMapping("/supplier/manageFoodItem")
	public String manageFoodItem(ModelMap model){
		model.addAttribute("foodItems", this.supplierService.getAllFoodItems());
		return "manageFoodItem";
	}
}
