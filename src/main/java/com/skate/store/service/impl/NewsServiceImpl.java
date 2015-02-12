package com.skate.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.News;
import com.skate.store.domain.User;
import com.skate.store.repository.NewsRepository;
import com.skate.store.service.NewsService;
import com.skate.store.service.UserService;

@Service
public class NewsServiceImpl implements NewsService{
	@Autowired private NewsRepository newsRepository; 
	@Autowired private UserService userService;
	
	@Override
	public List<News> findTopByOrderByIdDesc(Pageable page) {
		return newsRepository.findAll(page).getContent();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long newsId) {
		newsRepository.delete(newsId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public News findById(long newsId) {
		return newsRepository.findOne(newsId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(News news) {
		newsRepository.saveAndFlush(news);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(News news, String email) {
		User user = userService.findByEmail(email);
		news.setUser(user);
		newsRepository.saveAndFlush(news);
	}

	@Override
	public Page<News> findAll(Pageable page) {
		return newsRepository.findAll(page);
	}

	@Override
	public List<News> findTopByOrderByIdDesc() {
		return newsRepository.findTopByOrderByIdDesc();
	}


}
