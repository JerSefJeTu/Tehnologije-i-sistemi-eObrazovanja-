package com.ap.model.users.korisnik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public Korisnik findOne(Long id) {
		return korisnikRepository.findOne(id);
	}

	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	public Korisnik save(Korisnik Korisnik) {
		return korisnikRepository.save(Korisnik);
	}

	public void remove(Long id) {
		korisnikRepository.delete(id);
	}
	
	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByUserName(username);
	}

}
