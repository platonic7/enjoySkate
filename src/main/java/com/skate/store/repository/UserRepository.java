package com.skate.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
