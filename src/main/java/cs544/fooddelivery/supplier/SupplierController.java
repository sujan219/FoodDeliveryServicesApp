package cs544.fooddelivery.supplier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cs544.fooddelivery.domain.Category;
import cs544.fooddelivery.domain.Delivery;
import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.domain.Status;
import cs544.fooddelivery.domain.Supplier;
import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.order.OrderService;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
public class SupplierController {
	
	@Autowired
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Autowired
	SupplierService supplierService;
	
	@Autowired
	UserMgmtService userService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/supplier")
	public String displaySupplierDashboard(ModelMap model){
		Long supplierId = userService.getLoggedInUser().getId();
		model.addAttribute("orders", orderService.getAllRequestedOrderForSupplierId(supplierId));
		return "supplier";
	}
	
	//	public @ResponseBody String uploadFileHandler( @RequestParam("file") MultipartFile file) {
	@RequestMapping(value="/supplier/manageFoodItem/add", method=RequestMethod.POST)
	public String addFoodItem(
			@RequestParam("file") MultipartFile file,
			@RequestParam String imgUrl,
			@RequestParam double price,
			@RequestParam Long foodItemId,
			@RequestParam Long categoryId,
			@RequestParam String foodItemName,
			@RequestParam String foodItemDesc){

		FoodItem fi=new FoodItem();

		if(foodItemId!=null){
			fi.setId(foodItemId);
		}
		
		if(file.getSize() > 0) {
			fi.setImgUrl(this.saveImage(file));
    	}else{
    		fi.setImgUrl(imgUrl);
    	}

		fi.setCategory(this.supplierService.getCategoryWithCategoryId(categoryId));
		fi.setName(foodItemName);
		fi.setDescription(foodItemDesc);
		fi.setPrice(price);
		fi.setSupplier((Supplier)this.userService.getLoggedInUser());
		this.supplierService.saveFoodItem(fi);

		return "redirect:/supplier/manageFoodItem?";
	}
	
	private String saveImage(MultipartFile image)  {
		UUID idOne = UUID.randomUUID();
    	String fileName = idOne.toString();

    	String fullPathName = servletContext.getRealPath("/resources/images") + "/" + fileName;
	    File file = new File(fullPathName);
	    		
	    FileOutputStream stream;
		try {
			stream = new FileOutputStream(file);
		    stream.write(image.getBytes());
		    stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "/resources/images/" + fileName;
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
	
	@RequestMapping(value="/supplier/makeDelivery", method=RequestMethod.POST)
	public String makeDelivery(@RequestParam(value="orderIds[]") String[] orderIds){
		supplierService.saveDelivery(new Date(), orderIds);
		return "redirect:/supplier";
	}
	
	@RequestMapping(value="/supplier/deliveries")
	public String deliveryList(Model model){
		User loggedInUser = userService.getLoggedInUser();
		model.addAttribute("deliveries", supplierService.getAllDeliveries(loggedInUser.getId()));
		return "deliverylist";
	}
	
	@RequestMapping(value="/supplier/deliveries/{deliveryId}")
	public String deliveryDetail(@PathVariable long deliveryId, Model model){
		Delivery delivery = supplierService.getDelivery(deliveryId);
		model.addAttribute("delivery", delivery);
		return "deliverydetail";
	}
	
	@RequestMapping(value="/supplier/deliveries/{deliveryId}", method=RequestMethod.POST)
	public String deliveryDetailUpdate(@PathVariable long deliveryId, @RequestParam(value="distance") int distance){
		supplierService.completeDelivery(deliveryId, new Date(), distance);
		return "redirect:/supplier/deliveries";
	}
}
