package com.ap.model.users.vrstaPredavaca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VrstaPredavacaService {
	
	@Autowired
	VrstaPredavacaRepository vrstaPredavacaRepository;
	
	public VrstaPredavaca findOne(Long id) {
		return vrstaPredavacaRepository.findOne(id);
	}

	public List<VrstaPredavaca> findAll() {
		return vrstaPredavacaRepository.findAll();
	}

	public VrstaPredavaca save(VrstaPredavaca VrstaPredavaca) {
		return vrstaPredavacaRepository.save(VrstaPredavaca);
	}

	public void remove(Long id) {
		vrstaPredavacaRepository.delete(id);
	}

}
