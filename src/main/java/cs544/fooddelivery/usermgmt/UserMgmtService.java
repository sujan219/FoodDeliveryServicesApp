package cs544.fooddelivery.usermgmt;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.fooddelivery.domain.User;
import cs544.fooddelivery.repositories.UserDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserMgmtService {
	
	@Autowired
	private UserDAO userDAO;
	
	private User loggedInUser;
	
	public void addNewUser(User user){
		userDAO.save(user);
	}
	
	public User getUserByUserName(String userName){
		return userDAO.findOneByUserName(userName);
	}
	
	public void setLoggedInUser(String userName, HttpSession session){
		loggedInUser = userDAO.findOneByUserName(userName);
		session.setAttribute("user", loggedInUser);
	}
	
	public User getLoggedInUser() {
		return loggedInUser;
	}
}
