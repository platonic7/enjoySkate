package com.skate.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skate.store.domain.News;
import com.skate.store.service.NewsService;

@Controller
public class NewsController {
	@Autowired private NewsService newsService;
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String showNewsList(ModelMap map) {
		List<News> newsList  = newsService.findTopByOrderByIdDesc();
		map.put("newsList", newsList);
		return "news/news";
	}
}
