package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.BuyBoard;

public interface BuyBoardService {

	List<BuyBoard> findTopByOrderByTitleDesc();
	BuyBoard findById(long buyBoardId);
	void save(BuyBoard buyBoard, String email);
	void delete(long buyBoardId);
	
}
