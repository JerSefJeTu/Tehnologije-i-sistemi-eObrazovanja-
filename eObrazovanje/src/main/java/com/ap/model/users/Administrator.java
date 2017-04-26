package com.ap.model.users;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "KORISNIK_ID")
public class Administrator extends Korisnik {

	@Id
	@GeneratedValue
	private Long id;

	
	public Administrator() {
		super();
	}

	
	public Administrator(String firstName, String lastName, Long jMBG, String userName, String password,
			Date dateOfBirth, String placeOfOrigin, String currentAddress, String phoneNumber, String eMail) {
		super(firstName, lastName, jMBG, userName, password, dateOfBirth, placeOfOrigin, currentAddress, phoneNumber, eMail);
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}