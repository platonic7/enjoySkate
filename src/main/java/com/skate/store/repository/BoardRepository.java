package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findTopByOrderByTitleDesc();
	
}
