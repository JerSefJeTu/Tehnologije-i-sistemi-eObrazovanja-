package com.ap.model.kurs;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.predmet.Predmet;
import com.ap.model.users.predavac.Predavac;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
public class Kurs {
	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@ManyToOne
	private Predmet predmet;
	private Date datumPocetka;
	private Date datumKraja;
	
	
	@ManyToMany(mappedBy = "kursevi", fetch = FetchType.LAZY)
	private Set<Predavac> predavaci=new HashSet<Predavac>();
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "kurs")
	private Set<Pohadjanje> pohadjanja=new HashSet<Pohadjanje>();
	
	public Kurs(){
		
	}
	
	public Kurs(Long id, String naziv, Predmet predmet, Date datumPocetka, Date datumKraja,
			Set<Predavac> predavaci, Set<Pohadjanje> pohadjanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.predmet = predmet;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
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



	public Set<Predavac> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(Set<Predavac> predavaci) {
		this.predavaci = predavaci;
	}

	public Set<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(Set<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
	
	
	
}
