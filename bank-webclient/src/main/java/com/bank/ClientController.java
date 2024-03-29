package com.bank;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {
	
	@Autowired
	ClientAccountService clientAccountService;

	@Autowired
	ClientUserService clientUserService;
	
	@RequestMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model.addObject("user" , new User());
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/Authenticate")
	public ModelAndView loginAuthrntication(@ModelAttribute User user,ModelAndView model) {
		int result = clientUserService.login(user);
		if (result > 0) {
			List<Accounts> accList = clientAccountService.getAccount(result);
			model.addObject("accList" , accList);
			model.addObject("username"+user.getUsername());
			model.setViewName("accounthome");
			return model;
		} else {
			return new ModelAndView("login");
			
	}
}

}