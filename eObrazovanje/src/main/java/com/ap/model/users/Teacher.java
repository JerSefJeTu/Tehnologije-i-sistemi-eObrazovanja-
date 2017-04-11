package com.ap.model.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ap.model.workEntities.Kurs;

public class Teacher extends User {

	private Long id;
	private Set<Kurs> kursevi=new HashSet<Kurs>();
	private VrstaPredavaca vrstaPredavaca;
	private boolean aktivan;
	
	public Teacher() {
		super();
	}
	
	public Teacher(String firstName, String lastName, Long jMBG, String userName, String password, Date dateOfBirth,
			String placeOfOrigin, String currentAddress, String phoneNumber, String eMail) {
		super(firstName, lastName, jMBG, userName, password, dateOfBirth, placeOfOrigin, currentAddress, phoneNumber, eMail);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(Set<Kurs> kursevi) {
		this.kursevi = kursevi;
	}

	public VrstaPredavaca getVrstaPredavaca() {
		return vrstaPredavaca;
	}

	public void setVrstaPredavaca(VrstaPredavaca vrstaPredavaca) {
		this.vrstaPredavaca = vrstaPredavaca;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
}
