package com.skate.store.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skate.store.domain.BuyBoard;
import com.skate.store.service.BuyBoardService;

@Controller
public class BuyBoardController {
	@Autowired private BuyBoardService buyBoardService;
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";

	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/buycommunity", method = RequestMethod.GET)
	public String showBuyCommunityPage(ModelMap map) {
		List<BuyBoard> buyBoardList = buyBoardService.findTopByOrderByTitleDesc();
		map.put("buyBoardList", buyBoardList);
		return "buyandsell/buycommunity";
	}
	
	@RequestMapping(value = "/buyandsell/write", method = RequestMethod.GET)
	public String writePage() {
		return "buyandsell/write";
	}
	
	@RequestMapping(value = "/buyBoardWrite", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile file,BuyBoard buyBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		buyBoard.setImagePath(imagePath);

		buyBoardService.findById(1l);
		buyBoardService.save(buyBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/buycommunity";
	}
		
	@RequestMapping(value = "/buyandsell/{buyBoardId}/content", method = RequestMethod.GET)
	public String readPage(@PathVariable long buyBoardId, ModelMap model) {
		BuyBoard buyBoard = buyBoardService.findById(buyBoardId);
		model.addAttribute("buyBoard", buyBoard);
		return "buyandsell/content";
	}
	
	@RequestMapping(value = "/buyandsell/{buyBoardId}/update", method = RequestMethod.GET)
	public String enjoyTogetherUpdatePage(@PathVariable long buyBoardId, ModelMap map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BuyBoard buyBoard = buyBoardService.findById(buyBoardId);
		long buyBoardIdCheck = buyBoard.getId();
		
		if(buyBoard.getUser().getEmail().equals(email)) {
			map.addAttribute("buyBoard", buyBoard);
			return "/buyandsell/update";
		}
		return "redirect:/buyandsell/"+buyBoardIdCheck+"/content";
	}
	
	@RequestMapping(value = "/buyBoardUpdate", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file,BuyBoard buyBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		buyBoard.setImagePath(imagePath);

		buyBoardService.findById(1l);
		buyBoardService.save(buyBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/buycommunity";
	}
	
	@RequestMapping (value = "/buyandsell/{buyBoardId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable long buyBoardId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		BuyBoard buyBoard = buyBoardService.findById(buyBoardId);
		long buyBoardIdCheck = buyBoard.getId();
		
		if(buyBoard.getUser().getEmail().equals(email)) {
			buyBoardService.delete(buyBoardId);
			return "redirect:/buycommunity";
		}
		return "redirect:/buyandsell/"+buyBoardIdCheck+"/content";
	}
}








