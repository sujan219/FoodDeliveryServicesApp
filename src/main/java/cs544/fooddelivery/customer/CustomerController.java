package cs544.fooddelivery.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.usermgmt.UserMgmtService;

@Controller
public class CustomerController {

	@Autowired
	private UserMgmtService userMgmtService;

	@RequestMapping(value = { "/customer/dashborad" })
	public String main(Model model) {
		User customer = userMgmtService.getLoggedInUser();
		model.addAttribute("user", customer);
		return "dashboardCustomer";
	}
}