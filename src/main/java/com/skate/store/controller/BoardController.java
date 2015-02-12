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

import com.skate.store.domain.Board;
import com.skate.store.domain.News;
import com.skate.store.domain.Spot;
import com.skate.store.service.BoardService;
import com.skate.store.service.NewsService;
import com.skate.store.service.SpotService;

@Controller
public class BoardController {
	@Autowired private BoardService boardService;
	@Autowired private NewsService newsService;
	@Autowired private SpotService spotService;
	
	private String filePath = "/Users/JIN/Documents/workspace-sts-3.6.2.RELEASE/enjoySkate/src/main/webapp/resources/files";
	private String jspPath = "/resources/files/";

	static final String JSONVIEW = "jsonView";

	@RequestMapping(value = "/boards/write", method = RequestMethod.GET)
	public String mainPage() {
		return "boards/write";
	}
	
	@RequestMapping(value = "/boards", method = RequestMethod.POST)
	public String write(@RequestParam("file") MultipartFile file,Board board) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		board.setImagePath(imagePath);

		boardService.findById(1l);
		boardService.save(board, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/community";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file,Board board) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String imagePath = jspPath + file.getOriginalFilename();
		
		String email = auth.getName();
		board.setImagePath(imagePath);

		boardService.findById(1l);
		boardService.save(board, email);
		
		File javafiles = new File(filePath + "/" + file.getOriginalFilename());
		try {
			file.transferTo(javafiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/community";
	}

	@RequestMapping(value = "/boards/{boardId}/content", method = RequestMethod.GET)
	public String readPage(@PathVariable long boardId, Model model) {
		Board board = boardService.findById(boardId);
		model.addAttribute("board", board);
		return "boards/content";
	}

	@RequestMapping(value = "/boards/{boardId}/update", method = RequestMethod.GET)
	public String commentUpdatePage(@PathVariable long boardId, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		Board boardUpdate = boardService.findById(boardId);
		long boardIdCheck = boardUpdate.getId();
		if (boardUpdate.getUser().getEmail().equals(email)) {
			model.addAttribute("boardUpdate", boardUpdate);	
			return "boards/update";
		}
		return "redirect:/boards/"+boardIdCheck+"/content";
	}

	@RequestMapping(value = "/boards/{boardId}/delete", method = RequestMethod.GET)
	public String deleteBoard(@PathVariable long boardId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		
		Board board = boardService.findById(boardId);
		long boardIdCheck = board.getId();
		if (board.getUser().getEmail().equals(email)) {
			boardService.delete(boardId);
			return "redirect:/community";
		}
		return "redirect:/boards/"+boardIdCheck+"/content";
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap map, Pageable page) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			List<Board> boardList = boardService.findTopByOrderByTitleDesc();
			map.put("boardList", boardList);
			List<News> newsList  = newsService.findTopByOrderByIdDesc(page);
			map.put("newsList", newsList);
			List<Spot> spotList  = spotService.findTopByOrderByIdDesc();
			map.put("spotList", spotList);
			return "home";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String showCommunityPage(ModelMap map) {
		List<Board> boardList = boardService.findTopByOrderByTitleDesc();
		map.put("boardList", boardList);
		return "boards/community";
	}
}
