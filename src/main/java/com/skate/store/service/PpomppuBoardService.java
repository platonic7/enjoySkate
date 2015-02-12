package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.PpomppuBoard;

public interface PpomppuBoardService {

	PpomppuBoard findById(long ppomppuBoardId);
	List<PpomppuBoard> findTopByOrderByTitleDesc();
	void save(PpomppuBoard ppomppuBoard, String email);
	void delete(long ppomppuBoardId);
	
}
