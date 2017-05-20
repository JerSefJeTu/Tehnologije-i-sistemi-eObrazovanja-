package com.ap.model.users.korisnik;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.ap.model.users.administrator.Administrator;
import com.ap.model.users.predavac.Predavac;
import com.ap.model.users.student.Student;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIP_KORISNIKA")
public abstract class Korisnik {

	@javax.persistence.Id 
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private Long JMBG;
	private String userName;
	private String password;
	private Date dateOfBirth;
	private String placeOfOrigin;
	private String currentAddress;
	private String phoneNumber;
	private String eMail;

	
	public Korisnik(){
		
	}
	
	public Korisnik(String firstName, String lastName, Long jMBG, String userName, String password, Date dateOfBirth,
			String placeOfOrigin, String currentAddress, String phoneNumber, String eMail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		JMBG = jMBG;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.placeOfOrigin = placeOfOrigin;
		this.currentAddress = currentAddress;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getJMBG() {
		return JMBG;
	}
	public void setJMBG(Long jMBG) {
		JMBG = jMBG;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	
}