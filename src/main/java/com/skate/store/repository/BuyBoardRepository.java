package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.BuyBoard;

public interface BuyBoardRepository extends JpaRepository<BuyBoard, Long> {

	List<BuyBoard> findTopByOrderByTitleDesc();

}
