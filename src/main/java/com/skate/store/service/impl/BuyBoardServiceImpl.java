package com.skate.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.BuyBoard;
import com.skate.store.domain.User;
import com.skate.store.repository.BuyBoardRepository;
import com.skate.store.service.BuyBoardService;
import com.skate.store.service.UserService;

@Service
public class BuyBoardServiceImpl implements BuyBoardService {
	@Autowired private BuyBoardRepository buyBoardRepository;
	
	@Autowired private UserService userService;
	
	@Override
	public List<BuyBoard> findTopByOrderByTitleDesc() {
		return buyBoardRepository.findTopByOrderByTitleDesc();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public BuyBoard findById(long buyBoardId) {
		return buyBoardRepository.findOne(buyBoardId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(BuyBoard buyBoard, String email) {
		User user = userService.findByEmail(email);
		buyBoard.setUser(user);
		buyBoardRepository.saveAndFlush(buyBoard);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long buyBoardId) {
		buyBoardRepository.delete(buyBoardId);
	}
	
	
}
