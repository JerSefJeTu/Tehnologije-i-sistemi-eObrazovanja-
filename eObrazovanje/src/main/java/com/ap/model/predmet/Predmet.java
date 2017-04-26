package com.ap.model.predmet;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ap.model.kurs.Kurs;
import com.ap.model.users.Predavac;

@Entity
public class Predmet {
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "predmet")
	private Set<Kurs> kursevi=new HashSet<Kurs>();
	
	public Predmet(){
		
	}

	public Predmet(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
