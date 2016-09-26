package cs544.fooddelivery.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import cs544.fooddelivery.domain.FoodItem;
import cs544.fooddelivery.domain.Order;
import cs544.fooddelivery.domain.OrderLine;
import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.supplier.SupplierService;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
@SessionAttributes({"cart"})
public class CustomerController {

	@Autowired
	private UserMgmtService userMgmtService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = { "/home" })
	public String main(Model model) {
		//User customer = userMgmtService.getLoggedInUser();
		
		model.addAttribute("items", supplierService.getAllFoodItems());
		model.addAttribute("item", new FoodItem());
		return "home";
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public String addToCart(@ModelAttribute("item") FoodItem item, HttpServletRequest request){
			HttpSession session = request.getSession();
			
			Order order = customerService.addToCart(item,session);
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
	@RequestMapping(value="/updateCart", method=RequestMethod.POST)
	public String updateCart(@ModelAttribute("item") OrderLine orderLine, HttpServletRequest request){
			HttpSession session = request.getSession();
			
			Order order = customerService.updateCart(orderLine, session);
			session.setAttribute("order", order);	
			
			return "redirect:myCart";
	}
	
	@RequestMapping(value="/removeOrderLine", method=RequestMethod.POST)
	public String removeOrderLine(@ModelAttribute("item") OrderLine orderLine, HttpServletRequest request){
			HttpSession session = request.getSession();
			
			Order order = customerService.removeFromOrder(orderLine, session);
			session.setAttribute("order", order);	
			
			return "redirect:myCart";
	}
}
