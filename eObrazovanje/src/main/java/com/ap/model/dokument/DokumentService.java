package com.ap.model.dokument;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DokumentService{
	
	@Autowired
	DokumentRepository dokumentRepository;
	
	public Dokument findOne(Long id) {
		return dokumentRepository.findOne(id);
	}

	public List<Dokument> findAll() {
		return dokumentRepository.findAll();
	}

	public Dokument save(Dokument Dokument) {
		return dokumentRepository.save(Dokument);
	}

	public void remove(Long id) {
		dokumentRepository.delete(id);
	}

}
