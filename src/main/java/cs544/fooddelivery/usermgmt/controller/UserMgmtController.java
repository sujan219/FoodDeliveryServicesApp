package cs544.fooddelivery.usermgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMgmtController {
	@RequestMapping("/")
	public String main(){
		return "index";
	}
}
