package com.ap.model.polaganjeIspita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PolaganjeIspitaService {
	
	@Autowired
	PolaganjeIspitaRepository polaganjeIspitaRepository;
	
	public PolaganjeIspita findOne(Long id) {
		return polaganjeIspitaRepository.findOne(id);
	}

	public List<PolaganjeIspita> findAll() {
		return polaganjeIspitaRepository.findAll();
	}

	public PolaganjeIspita save(PolaganjeIspita PolaganjeIspita) {
		return polaganjeIspitaRepository.save(PolaganjeIspita);
	}

	public void remove(Long id) {
		polaganjeIspitaRepository.delete(id);
	}

}
