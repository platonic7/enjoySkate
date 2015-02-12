package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.EnjoyBoard;

public interface EnjoyBoardRepository extends JpaRepository<EnjoyBoard, Long> {
	
	List<EnjoyBoard> findTopByOrderByTitleDesc();
	
}
