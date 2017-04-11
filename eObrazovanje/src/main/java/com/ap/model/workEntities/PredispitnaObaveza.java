package com.ap.model.workEntities;

import java.util.Date;
import java.util.Set;

import com.ap.model.users.Teacher;

public class PredispitnaObaveza {

	private Long id;
	private Date datumPolaganja;
	private boolean polozio;
	private String nazivObaveze;
	private Set<Teacher> dezurniPredavaci;
	private double brojBodova;
	private double minBodova;
	
	public PredispitnaObaveza(){
		
	}

	public PredispitnaObaveza(Long id, Date datumPolaganja, boolean polozio, String nazivObaveze,
			Set<Teacher> dezurniPredavaci, double brojBodova, double minBodova) {
		super();
		this.id = id;
		this.datumPolaganja = datumPolaganja;
		this.polozio = polozio;
		this.nazivObaveze = nazivObaveze;
		this.dezurniPredavaci = dezurniPredavaci;
		this.brojBodova = brojBodova;
		this.minBodova = minBodova;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}

	public String getNazivObaveze() {
		return nazivObaveze;
	}

	public void setNazivObaveze(String nazivObaveze) {
		this.nazivObaveze = nazivObaveze;
	}

	public Set<Teacher> getDezurniPredavaci() {
		return dezurniPredavaci;
	}

	public void setDezurniPredavaci(Set<Teacher> dezurniPredavaci) {
		this.dezurniPredavaci = dezurniPredavaci;
	}

	public double getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}

	public double getMinBodova() {
		return minBodova;
	}

	public void setMinBodova(double minBodova) {
		this.minBodova = minBodova;
	}
	
}
