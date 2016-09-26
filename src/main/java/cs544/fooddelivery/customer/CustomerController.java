package cs544.fooddelivery.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.domain.Order;
import cs544.fooddelivery.domain.OrderLine;
import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.supplier.SupplierService;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
@SessionAttributes({ "cart" })
public class CustomerController {

	@Autowired
	private UserMgmtService userMgmtService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String main(Model model, SearchObject obj) {
		List<FoodItem> foodItems = supplierService.getAllFoodItems();
		if(obj != null){
			long supplierId = obj.getSupplierId();
			long categoryId = obj.getCategoryId();
			String searchText = obj.getSearchText();
			
			List<FoodItem> foodItems2 = new ArrayList<FoodItem>();
			if (supplierId!=0) {
				for(FoodItem fi:foodItems){
					if(fi.getSupplier().getId() == supplierId){
						foodItems2.add(fi);
					}
				}
				foodItems = foodItems2;
				foodItems2 = new ArrayList<FoodItem>();
			}
			
			if (categoryId != 0) {
				for(FoodItem fi:foodItems){
					if(fi.getCategory().getId() == categoryId){
						foodItems2.add(fi);
					}
				}
				foodItems = foodItems2;
				foodItems2 = new ArrayList<FoodItem>();
			}

			if (searchText != null && searchText.length() > 0) {
				for(FoodItem fi:foodItems){
					if(fi.getName().contains(searchText)){
						foodItems2.add(fi);
					}
				}
				foodItems = foodItems2;
			}
		}

		model.addAttribute("items", foodItems);
		model.addAttribute("item", new FoodItem());
		model.addAttribute("categories", supplierService.getAllCategories());
		model.addAttribute("suppliers", supplierService.getAllSuppliers());
		if(obj == null){
			obj = new SearchObject();
		}
		model.addAttribute("searchObj", obj);
		return "home";
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("item") FoodItem item, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Order order = customerService.addToCart(item, session);
		session.setAttribute("order", order);

		return "redirect:home";
	}

	@RequestMapping(value = { "/myCart" })
	public String myCart(Model model) {
		User user = userMgmtService.getLoggedInUser();
		model.addAttribute("item", new OrderLine());
		model.addAttribute("user", user);
		return "myCart";
	}

	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	public String updateCart(@ModelAttribute("item") OrderLine orderLine, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Order order = customerService.updateCart(orderLine, session);
		session.setAttribute("order", order);

		return "redirect:myCart";
	}

	@RequestMapping(value = "/removeOrderLine", method = RequestMethod.POST)
	public String removeOrderLine(@ModelAttribute("item") OrderLine orderLine, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Order order = customerService.removeFromOrder(orderLine, session);
		session.setAttribute("order", order);

		return "redirect:myCart";
	}
}