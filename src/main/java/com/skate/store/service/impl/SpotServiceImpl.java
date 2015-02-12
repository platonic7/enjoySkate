package com.skate.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.Spot;
import com.skate.store.domain.User;
import com.skate.store.repository.SpotRepository;
import com.skate.store.service.SpotService;
import com.skate.store.service.UserService;

@Service
public class SpotServiceImpl implements SpotService{
	@Autowired private SpotRepository spotRepository;
	@Autowired private UserService userService;
	
	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public List<Spot> findTopByOrderByIdDesc() {
		return spotRepository.findTopByOrderByIdDesc();
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(Spot spot, String email) {
		User user = userService.findByEmail(email);
		spot.setUser(user);
		spotRepository.saveAndFlush(spot);
	}

	@Override
	public Spot findById(long spotId) {
		return spotRepository.findOne(spotId);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(Spot spot) {
		spotRepository.saveAndFlush(spot);
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void delete(long spotId) {
		spotRepository.delete(spotId);
	}
}
