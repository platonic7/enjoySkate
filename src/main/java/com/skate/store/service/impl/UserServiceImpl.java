package com.skate.store.service.impl;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skate.store.domain.User;
import com.skate.store.repository.UserRepository;
import com.skate.store.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserRepository userRepository;

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void save(User user) {
		User oldUser = userRepository.findByEmail(user.getEmail());
		if(Objects.isNull(oldUser)) {
			userRepository.saveAndFlush(user);
		} else {
			oldUser.update(user);
			userRepository.saveAndFlush(oldUser);
		}
	}

	@Override
	public String findQuizByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user.getQuiz();
		
	}

	@Override
	public boolean checkSolution(String email, String solution) {
		User user = userRepository.findByEmail(email);
		return user.getQuizResult().equals(solution);
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User findById(String userId) {
		User user = userRepository.findByEmail(userId);
		return user;
	}

	@Override
	public User findById(long userId) {
		return userRepository.findOne(userId);
	}
}
