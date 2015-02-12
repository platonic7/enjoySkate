package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.EnjoyBoard;

public interface EnjoyBoardService {

	List<EnjoyBoard> findTopByOrderByTitleDesc();
	EnjoyBoard findById(long enjoyBoardId);
	void save(EnjoyBoard enjoyBoard, String email);
	void delete(long enjoyBoardId);
	
}