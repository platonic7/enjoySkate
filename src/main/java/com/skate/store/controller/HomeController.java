package com.skate.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skate.store.service.BoardService;

@Controller
public class HomeController {
	@Autowired private BoardService boardService;
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/skate", method = RequestMethod.GET)
	public String skateInfo() {
		return "info/skate";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	public String terms () {
		return "info/terms";
	}
	
	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public String privacy () {
		return "info/privacy";
	}
	
	//Spring Security see this :
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(String error, String logout) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			boolean isLogined = auth != null;
	 
			ModelAndView model = new ModelAndView();
			model.addObject("isLogined", isLogined);
			if (error != null) {
				if(error.equals("denied")) {
					model.addObject("error", "접속권한이 없습니다.");
				} else {
					model.addObject("error", "Invalid Email and Password!");
				}
			}
	 
			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.setViewName("login");
	 
			return model;
	 
		}
}
