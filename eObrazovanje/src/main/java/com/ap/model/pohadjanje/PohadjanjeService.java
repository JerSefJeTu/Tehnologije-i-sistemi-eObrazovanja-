package com.ap.model.pohadjanje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PohadjanjeService {

	
	@Autowired
	PohadjanjeRepository pohadjanjeRepository;
	
	public Pohadjanje findOne(Long id) {
		return pohadjanjeRepository.findOne(id);
	}

	public List<Pohadjanje> findAll() {
		return pohadjanjeRepository.findAll();
	}

	public Pohadjanje save(Pohadjanje Pohadjanje) {
		return pohadjanjeRepository.save(Pohadjanje);
	}

	public void remove(Long id) {
		pohadjanjeRepository.delete(id);
	}
}
