package com.ap.model.users;

import java.util.Date;

public class Administrator extends User {

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