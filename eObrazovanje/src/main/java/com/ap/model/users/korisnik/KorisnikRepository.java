package com.ap.model.users.korisnik;

import org.springframework.data.jpa.repository.JpaRepository;



public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	public Korisnik findByUserName(String username);

}
