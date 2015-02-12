package com.skate.store.service;

import java.util.List;

import com.skate.store.domain.Spot;

public interface SpotService {

	List<Spot> findTopByOrderByIdDesc();
	Spot findById(long spotId);
	void save(Spot spot, String email);
	void save(Spot spot);
	void delete(long spotId);

}
