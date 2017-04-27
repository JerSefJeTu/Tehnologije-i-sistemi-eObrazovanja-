package com.ap.model.kurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KursService {
	
	
	@Autowired
	KursRepository kursRepository;
	
	public Kurs findOne(Long id) {
		return kursRepository.findOne(id);
	}

	public List<Kurs> findAll() {
		return kursRepository.findAll();
	}

	public Kurs save(Kurs Kurs) {
		return kursRepository.save(Kurs);
	}

	public void remove(Long id) {
		kursRepository.delete(id);
	}


}
