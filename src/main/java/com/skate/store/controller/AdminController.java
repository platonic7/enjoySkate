package com.skate.store.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skate.store.domain.News;
import com.skate.store.domain.Spot;
import com.skate.store.service.NewsService;
import com.skate.store.service.SpotService;


@Controller
public class AdminController {
	@Autowired private NewsService newsService;
	@Autowired private SpotService spotService;
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";
	
	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin/news/write", method = RequestMethod.GET)
	public String newsWritePage() {
		return "admin/news/write";
	}
	
	@RequestMapping(value = "/news/write", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile file,News news) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		news.setImagePath(imagePath);

		newsService.findById(1l);
		newsService.save(news, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value = "/news/update", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file,News news) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		news.setImagePath(imagePath);

		newsService.findById(1l);
		newsService.save(news, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value = "/admin/{newsId}/update", method = RequestMethod.GET)
	public String updatePage(@PathVariable long newsId, Model model) {
		News newsUpdate = newsService.findById(newsId);
		model.addAttribute("newsUpdate", newsUpdate);
		return "admin/news/update";
	}
	
	@RequestMapping(value = "/admin/news", method = RequestMethod.GET)
	public String showAdminNewsListPage(ModelMap map, Pageable page) {
		List<News> newsList  = newsService.findTopByOrderByIdDesc(page);
		map.put("newsList", newsList);
		return "admin/news/list";
	}
	
	@RequestMapping(value = "/admin/{newsId}/delete", method = RequestMethod.GET)
	public String deleteNews(@PathVariable long newsId) {
		newsService.delete(newsId);
		return "admin/main";
	}
	
	@RequestMapping(value = "/news/{newsId}/detail", method = RequestMethod.GET)
	public String newsReadOnlyPage(@PathVariable long newsId, Model model) {
		News news = newsService.findById(newsId);
		model.addAttribute("news", news);
		return "news/detail";
	}
	

	/* Spots */
	@RequestMapping(value = "/admin/spots/write", method = RequestMethod.GET)
	public String spotsWritePage() {
		return "admin/spots/write";
	}
	
	@RequestMapping(value = "/admin/spots", method = RequestMethod.GET)
	public String showAdminSpotsList(ModelMap map) {
		List<Spot> spotList  = spotService.findTopByOrderByIdDesc();
		map.put("spotList", spotList);
		return "admin/spots/list";
	}
	
	@RequestMapping(value = "/spots/{spotId}/detail", method = RequestMethod.GET)
	public String spotReadOnlyPage(@PathVariable long spotId, Model model) {
		Spot spot = spotService.findById(spotId);
		model.addAttribute("spot", spot);
		System.out.println("디테일 " + spot);
		System.out.println("디테일 " + model);
		return "spots/detail";
	}
	
	@RequestMapping(value = "/spots/{spotId}/delete", method = RequestMethod.GET)
	public String deleteSpot(@PathVariable long spotId) {
		spotService.delete(spotId);
		return "admin/main";
	}
	
	@RequestMapping(value = "/spots/{spotId}/update", method = RequestMethod.GET)
	public String showSpotUpdatePage(@PathVariable long spotId, Model model) {
		Spot spotUpdate = spotService.findById(spotId);
		model.addAttribute("spotUpdate", spotUpdate);
		return "admin/spots/update";
	}
	
	@RequestMapping(value = "/spots/write", method = RequestMethod.POST)
	public String writeSpotsReview(@RequestParam("file") MultipartFile file,Spot spot) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		spot.setImagePath(imagePath);

		spotService.findById(1l);
		spotService.save(spot, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/spots";
	}
	
	@RequestMapping(value = "/spots/update", method = RequestMethod.POST)
	public String updateSpot(@RequestParam("file") MultipartFile file,Spot spot) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		spot.setImagePath(imagePath);

		spotService.findById(1l);
		spotService.save(spot, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/spots";
	}
}
