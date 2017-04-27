package com.ap.model.uplata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UplataService {

	@Autowired
	UplataRepository uplataRepository;
	
	public Uplata findOne(Long id) {
		return uplataRepository.findOne(id);
	}

	public List<Uplata> findAll() {
		return uplataRepository.findAll();
	}

	public Uplata save(Uplata Uplata) {
		return uplataRepository.save(Uplata);
	}

	public void remove(Long id) {
		uplataRepository.delete(id);
	}
}
