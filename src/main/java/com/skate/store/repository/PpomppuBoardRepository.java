package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.PpomppuBoard;

public interface PpomppuBoardRepository extends JpaRepository<PpomppuBoard, Long> {

	List<PpomppuBoard> findTopByOrderByTitleDesc();
	
}
