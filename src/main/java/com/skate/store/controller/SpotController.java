package com.skate.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.Spot;
import com.skate.store.service.SpotService;

@Controller
public class SpotController {
	@Autowired private SpotService spotService;
	
	static final String JSONVIEW = "jsonview";
	
	@RequestMapping(value = "/spots", method = RequestMethod.GET)
	public String showSpotsList(ModelMap map) {
		List<Spot> spotList  = spotService.findTopByOrderByIdDesc();
		map.put("spotList", spotList);
		return "spots/spots";
	}
}
