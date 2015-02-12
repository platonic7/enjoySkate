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

import com.skate.store.domain.PpomppuBoard;
import com.skate.store.service.PpomppuBoardService;

@Controller
public class PpomppuBoardController {
	@Autowired private PpomppuBoardService ppomppuBoardService;
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";

	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/ppomppucommunity", method = RequestMethod.GET)
	public String showCommunityPage(ModelMap map) {
		List<PpomppuBoard> ppomppuBoardList = ppomppuBoardService.findTopByOrderByTitleDesc();
		map.put("ppomppuBoardList", ppomppuBoardList);
		return "ppomppu/ppomppucommunity";
	}
	
	@RequestMapping(value = "/ppomppu/write", method = RequestMethod.GET)
	public String writePage() {
		return "ppomppu/write";
	}
	
	@RequestMapping(value = "/ppomppuWrite", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile file,PpomppuBoard ppomppuBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		ppomppuBoard.setImagePath(imagePath);

		ppomppuBoardService.findById(1l);
		ppomppuBoardService.save(ppomppuBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ppomppucommunity";
	}
		
	@RequestMapping(value = "/ppomppu/{ppomppuBoardId}/content", method = RequestMethod.GET)
	public String readPage(@PathVariable long ppomppuBoardId, ModelMap model) {
		PpomppuBoard ppomppuBoard = ppomppuBoardService.findById(ppomppuBoardId);
		model.addAttribute("ppomppuBoard", ppomppuBoard);
		return "ppomppu/content";
	}
	
	@RequestMapping(value = "/ppomppu/{ppomppuBoardId}/update", method = RequestMethod.GET)
	public String ppomppuUpdatePage(@PathVariable long ppomppuBoardId, ModelMap map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		PpomppuBoard ppomppuBoard = ppomppuBoardService.findById(ppomppuBoardId);
		long ppomppuBoardIdCheck = ppomppuBoard.getId();
		
		if(ppomppuBoard.getUser().getEmail().equals(email)) {
			map.addAttribute("ppomppuBoard", ppomppuBoard);
			return "/ppomppu/update";
		}
		return "redirect:/ppomppu/"+ppomppuBoardIdCheck+"/content";
	}
	
	@RequestMapping(value = "/ppomppuBoardUpdate", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file,PpomppuBoard ppomppuBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		ppomppuBoard.setImagePath(imagePath);

		ppomppuBoardService.findById(1l);
		ppomppuBoardService.save(ppomppuBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ppomppucommunity";
	}
	
	@RequestMapping (value = "/ppomppu/{ppomppuBoardId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable long ppomppuBoardId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		PpomppuBoard ppomppuBoard = ppomppuBoardService.findById(ppomppuBoardId);
		long ppomppuBoardIdCheck = ppomppuBoard.getId();
		
		if(ppomppuBoard.getUser().getEmail().equals(email)) {
			ppomppuBoardService.delete(ppomppuBoardId);
			return "redirect:/ppomppucommunity";
		}
		return "redirect:/ppomppu/"+ppomppuBoardIdCheck+"/content";
	}
}