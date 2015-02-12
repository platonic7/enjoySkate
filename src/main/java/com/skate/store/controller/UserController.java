package com.skate.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.User;
import com.skate.store.service.UserService;

@Controller
public class UserController {
	@Autowired private UserService userService;

	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/users/join", method = RequestMethod.GET)
	public String mainPage() {
		return "users/join";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String joinUser(User user) {
		userService.save(user);
		return JSONVIEW;
	}
	
	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public String findQuizByEmail(String email, ModelMap map) {
		String quiz = userService.findQuizByEmail(email); // 구현해야
		map.put("quiz", quiz);
		return JSONVIEW;
	}
	
	@RequestMapping(value = "/quiz/check", method = RequestMethod.GET)
	public String checkSolution(String email, String solution, ModelMap map) {
		boolean result = userService.checkSolution(email, solution);
		String passwd = "";
		if(result) {
			User user = userService.findByEmail(email);
			passwd = user.getPassword();
		}
		map.put("result", result);
		map.put("passwd", passwd);
		return JSONVIEW;
	}

	// users/password controller
	@RequestMapping(value = "/users/password", method = RequestMethod.GET)
	public String findPasswordPage() {
		return "users/password";
	}
	
	@RequestMapping(value = "/users/my-info", method = RequestMethod.GET)
	public String goMyInfoPage(ModelMap map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User user = userService.findByEmail(email);
		map.put("user", user);
		return "users/detail";
	}
}
