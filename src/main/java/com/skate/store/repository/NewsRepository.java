package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.News;

public interface NewsRepository extends JpaRepository<News, Long>{
	
	List<News> findTopByOrderByIdDesc();

}
