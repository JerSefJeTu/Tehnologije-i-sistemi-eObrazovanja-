package com.ap.model.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ap.model.workEntities.Dokument;
import com.ap.model.workEntities.Pohadjanje;

public class Student extends User {
	
	private Long id;
	private double stanje;
	private Set<Dokument> dokumenti=new HashSet<Dokument>();
	private Set<Pohadjanje> pohadjanja=new HashSet<Pohadjanje>();
	
	
	public Student() {
		super();
	}
	
	
	public Student(String firstName, String lastName, Long jMBG, String userName, String password, Date dateOfBirth,
			String placeOfOrigin, String currentAddress, String phoneNumber, String eMail) {
		super(firstName, lastName, jMBG, userName, password, dateOfBirth, placeOfOrigin, currentAddress, phoneNumber, eMail);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
	public Set<Dokument> getDokumenti() {
		return dokumenti;
	}
	public void setDokumenti(Set<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}
	public Set<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}
	public void setPohadjanja(Set<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}
	
	
	
}

