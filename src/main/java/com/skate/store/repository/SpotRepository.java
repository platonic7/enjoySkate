package com.skate.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skate.store.domain.Spot;

public interface SpotRepository extends JpaRepository<Spot, Long>{
		
	List<Spot> findTopByOrderByIdDesc();
	
}
