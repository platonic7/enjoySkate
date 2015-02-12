package com.skate.store.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skate.store.domain.Board;
import com.skate.store.service.BoardService;
import com.skate.store.service.NewsService;

@Controller
public class FileUploadController {
	static final String JSONVIEW = "jsonView";
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";
	
	@Autowired private BoardService boardService;
	@Autowired private NewsService newsService;
	
	@RequestMapping(value="/file/upload", method = RequestMethod.POST)
	public String process(@RequestParam("file") MultipartFile file) {
		String imagePath = jspPath + file.getOriginalFilename();
		
		Board board = boardService.findById(1l);
		board.setImagePath(imagePath);
		boardService.save(board);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login";
	}
}
