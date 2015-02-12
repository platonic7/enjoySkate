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

import com.skate.store.domain.EnjoyBoard;
import com.skate.store.service.EnjoyBoardService;

@Controller
public class EnjoyBoardController {
	@Autowired private EnjoyBoardService enjoyBoardService;
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";

	static final String JSONVIEW = "jsonView";
	
	@RequestMapping(value = "/enjoycommunity", method = RequestMethod.GET)
	public String showCommunityPage(ModelMap map) {
		List<EnjoyBoard> enjoyBoardList = enjoyBoardService.findTopByOrderByTitleDesc();
		map.put("enjoyBoardList", enjoyBoardList);
		return "enjoyTogether/enjoytogether";
	}
	
	@RequestMapping(value = "/enjoyTogether/write", method = RequestMethod.GET)
	public String writePage() {
		return "enjoyTogether/write";
	}
	
	@RequestMapping(value = "/enjoyBoardWrite", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile file,EnjoyBoard enjoyBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		enjoyBoard.setImagePath(imagePath);

		enjoyBoardService.findById(1l);
		enjoyBoardService.save(enjoyBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/enjoycommunity";
	}
		
	@RequestMapping(value = "/enjoyTogether/{enjoyBoardId}/content", method = RequestMethod.GET)
	public String readPage(@PathVariable long enjoyBoardId, ModelMap model) {
		EnjoyBoard enjoyBoard = enjoyBoardService.findById(enjoyBoardId);
		model.addAttribute("enjoyBoard", enjoyBoard);
		return "enjoyTogether/content";
	}
	
	@RequestMapping(value = "/enjoyTogether/{enjoyBoardId}/update", method = RequestMethod.GET)
	public String enjoyTogetherUpdatePage(@PathVariable long enjoyBoardId, ModelMap map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		EnjoyBoard enjoyBoard = enjoyBoardService.findById(enjoyBoardId);
		long enjoyBoardIdCheck = enjoyBoard.getId();
		
		if(enjoyBoard.getUser().getEmail().equals(email)) {
			map.addAttribute("enjoyBoard", enjoyBoard);
			return "/enjoyTogether/update";
		}
		return "redirect:/enjoyTogether/"+enjoyBoardIdCheck+"/content";
	}
	
	@RequestMapping(value = "/enjoyBoardUpdate", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file,EnjoyBoard enjoyBoard) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		enjoyBoard.setImagePath(imagePath);

		enjoyBoardService.findById(1l);
		enjoyBoardService.save(enjoyBoard, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/enjoycommunity";
	}
	
	@RequestMapping (value = "/enjoyTogether/{enjoyBoardId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable long enjoyBoardId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		EnjoyBoard enjoyBoard = enjoyBoardService.findById(enjoyBoardId);
		long enjoyBoardIdCheck = enjoyBoard.getId();
		
		if(enjoyBoard.getUser().getEmail().equals(email)) {
			enjoyBoardService.delete(enjoyBoardId);
			return "redirect:/enjoycommunity";
		}
		return "redirect:/enjoyTogether/"+enjoyBoardIdCheck+"/content";
	}
}








