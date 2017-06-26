package com.ap.web.dto;

import com.ap.model.kurs.Kurs;

public class KursDTO {
	
	private Long id;
	private String naziv;
	public KursDTO() {
		super();
	}
	public KursDTO(Kurs kurs) {
		this(kurs.getId(), kurs.getNaziv());
	}
	
	
	
	public KursDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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

	
}
