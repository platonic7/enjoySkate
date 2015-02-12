package com.skate.store.service;

import com.skate.store.domain.User;

public interface UserService {

	boolean checkSolution(String email, String solution);
	String findQuizByEmail(String email);
	User findByEmail(String email);
	User findById(String userId);
	User findById(long userId);
	void save(User user);

}
