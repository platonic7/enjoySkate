package com.skate.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.PpomppuBoard;
import com.skate.store.domain.User;
import com.skate.store.repository.PpomppuBoardRepository;
import com.skate.store.service.PpomppuBoardService;
import com.skate.store.service.UserService;

@Service
public class PpomppuBoardServiceImpl implements PpomppuBoardService {
	@Autowired private PpomppuBoardRepository ppomppuBoardRepository;
	@Autowired private UserService userService;

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public PpomppuBoard findById(long ppomppuBoardId) {
		return ppomppuBoardRepository.findOne(ppomppuBoardId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public List<PpomppuBoard> findTopByOrderByTitleDesc() {
		return ppomppuBoardRepository.findTopByOrderByTitleDesc();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(PpomppuBoard ppomppuBoard, String email) {
		User user = userService.findByEmail(email);
		ppomppuBoard.setUser(user);
		ppomppuBoardRepository.saveAndFlush(ppomppuBoard);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long ppomppuBoardId) {
		ppomppuBoardRepository.delete(ppomppuBoardId);
	}
}
