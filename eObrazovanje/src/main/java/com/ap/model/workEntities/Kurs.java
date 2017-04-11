package com.ap.model.workEntities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ap.model.users.Student;
import com.ap.model.users.Teacher;

public class Kurs {

	private Long id;
	private String naziv;
	private Predmet predmet;
	private Date datumPocetka;
	private Date datumKraja;
	private Set<Student> studenti=new HashSet<Student>();
	private Set<Teacher> predavaci=new HashSet<Teacher>();
	private Set<Pohadjanje> pohadjanja=new HashSet<Pohadjanje>();
	
	public Kurs(){
		
	}
	
	public Kurs(Long id, String naziv, Predmet predmet, Date datumPocetka, Date datumKraja, Set<Student> studenti,
			Set<Teacher> predavaci, Set<Pohadjanje> pohadjanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.predmet = predmet;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.studenti = studenti;
		this.predavaci = predavaci;
		this.pohadjanja = pohadjanja;
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

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Student> studenti) {
		this.studenti = studenti;
	}

	public Set<Teacher> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(Set<Teacher> predavaci) {
		this.predavaci = predavaci;
	}

	public Set<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(Set<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
	
	
	
}
