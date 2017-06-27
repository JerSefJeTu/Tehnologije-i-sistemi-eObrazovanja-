package com.ap.web.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import com.ap.model.dokument.Dokument;
import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.uplata.Uplata;
import com.ap.model.users.student.Student;

public class StudentDTO {
	
	private Long id;
	private double stanje;
	private String firstname;
	private String lastname;
	private Long JMBG;
	private String username;
	private Date dateOfBirth;
	private String placeOfOrigin;
	private String currentAddress;
	private String phoneNumber;
	private String email;
	
	private Set<Dokument> dokumenti=new HashSet<Dokument>();
	
	
	private Set<Uplata> uplate=new HashSet<Uplata>();

	
	public StudentDTO(Student student) {
		super();
		this.id= student.getId() ;
		this.stanje = student.getStanje();
		this.dokumenti = student.getDokumenti();
		this.uplate = this.getUplate();
		this.firstname = student.getFirstName();
		this.lastname = student.getLastName();
		this.JMBG = student.getJMBG();
		this.username = student.getUserName();
		this.dateOfBirth = student.getDateOfBirth();
		this.placeOfOrigin = student.getPlaceOfOrigin();
		this.currentAddress = student.getCurrentAddress();
		this.phoneNumber = student.getPhoneNumber();
		this.email = student.geteMail();
	}

	public StudentDTO() {
		super();
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


	public Set<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getJMBG() {
		return JMBG;
	}

	public void setJMBG(Long jMBG) {
		JMBG = jMBG;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
