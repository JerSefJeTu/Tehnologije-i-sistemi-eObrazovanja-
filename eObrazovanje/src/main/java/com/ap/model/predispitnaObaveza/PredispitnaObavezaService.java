package com.ap.model.predispitnaObaveza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PredispitnaObavezaService {
	
	@Autowired
	PredispitnaObavezaRepository predispitnaObavezaRepiository;
	
	public PredispitnaObaveza findOne(Long id) {
		return predispitnaObavezaRepiository.findOne(id);
	}

	public List<PredispitnaObaveza> findAll() {
		return predispitnaObavezaRepiository.findAll();
	}

	public PredispitnaObaveza save(PredispitnaObaveza PredispitnaObaveza) {
		return predispitnaObavezaRepiository.save(PredispitnaObaveza);
	}

	public void remove(Long id) {
		predispitnaObavezaRepiository.delete(id);
	}

}
