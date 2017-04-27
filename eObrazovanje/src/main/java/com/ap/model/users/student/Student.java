package com.ap.model.users.student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.ap.model.dokument.Dokument;
import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.uplata.Uplata;
import com.ap.model.users.korisnik.Korisnik;


@Entity
@DiscriminatorValue("STUDENT")
@PrimaryKeyJoinColumn(name = "KORISNIK_ID")
public class Student extends Korisnik {
	
	@Id
	@GeneratedValue
	private Long id;
	private double stanje;
	@OneToMany(mappedBy="student")
	private Set<Dokument> dokumenti=new HashSet<Dokument>();
	@OneToMany(mappedBy="student")
	private Set<Pohadjanje> pohadjanja=new HashSet<Pohadjanje>();
	@OneToMany(mappedBy="student")
	private Set<Uplata> uplate=new HashSet<Uplata>();
	
	
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


	public Set<Uplata> getUplate() {
		return uplate;
	}


	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}


	
	
	
	
}

