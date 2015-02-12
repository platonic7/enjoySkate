package com.skate.store.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skate.store.domain.News;

public interface NewsService {

	List<News> findTopByOrderByIdDesc(Pageable page);
	Page<News> findAll(Pageable page);
	News findById(long newsId);
	List<News> findTopByOrderByIdDesc();
	void delete(long newsId);
	void save(News news);
	void save(News news, String email);

}
