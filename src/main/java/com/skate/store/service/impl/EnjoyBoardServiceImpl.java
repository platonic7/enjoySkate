package com.skate.store.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.EnjoyBoard;
import com.skate.store.domain.User;
import com.skate.store.repository.EnjoyBoardRepository;
import com.skate.store.service.EnjoyBoardService;
import com.skate.store.service.UserService;

@Service
public class EnjoyBoardServiceImpl implements EnjoyBoardService {
	@Autowired private EnjoyBoardRepository enjoyBoardRepository;
	
	@Autowired private UserService userService;

	@Override  // Read
	public List<EnjoyBoard> findTopByOrderByTitleDesc() {
		return enjoyBoardRepository.findTopByOrderByTitleDesc();
	}

	@Override  
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public EnjoyBoard findById(long enjoyBoardId) {
		return enjoyBoardRepository.findOne(enjoyBoardId);
	}

	@Override  // Create
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(EnjoyBoard enjoyBoard, String email) {
		User user = userService.findByEmail(email);
		enjoyBoard.setUser(user);
		enjoyBoardRepository.saveAndFlush(enjoyBoard);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long enjoyBoardId) {
		enjoyBoardRepository.delete(enjoyBoardId);
	}
	

	
}
