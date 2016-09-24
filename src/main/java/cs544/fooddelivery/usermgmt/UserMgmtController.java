package cs544.fooddelivery.usermgmt;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import cs544.fooddelivery.domain.User;

@Controller
public class UserMgmtController {
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@RequestMapping(value={"/", "/login"})
	public String main(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "index";
	}
	
	@RequestMapping("/loginSuccess")
	public View loginSuccess(){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		if(roles.contains("ROLE_ADMIN")){
			return new RedirectView("dashboard_admin");
		}else if(roles.contains("ROLE_SUPPLIER")){
			userMgmtService.setLoggedInUser(userName);
			return new RedirectView("dashboard_supplier");
		}else{
			userMgmtService.setLoggedInUser(userName);
			return new RedirectView("customer/dashborad");
		}
	}
	
	@RequestMapping("/signup")
	public String openSignup(Model model){
		model.addAttribute("user", new UserMediator());
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("user") @Validated UserMediator user, BindingResult result, Model model){
		if(result.hasErrors()){
			return "signup";
		}else{
			User domainUser = user.getDomainUser();
			userMgmtService.addNewUser(domainUser);
			model.addAttribute("msg", "Signup successful! You can now login");
			return "index";
		}
	}
}
