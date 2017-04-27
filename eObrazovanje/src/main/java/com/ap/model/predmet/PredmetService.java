package com.ap.model.predmet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmentRepository;
	
	public Predmet findOne(Long id) {
		return predmentRepository.findOne(id);
	}

	public List<Predmet> findAll() {
		return predmentRepository.findAll();
	}

	public Predmet save(Predmet Predmet) {
		return predmentRepository.save(Predmet);
	}

	public void remove(Long id) {
		predmentRepository.delete(id);
	}
}
