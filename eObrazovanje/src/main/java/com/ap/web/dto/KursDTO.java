package com.ap.web.dto;

import java.util.HashSet;
import java.util.Set;

import com.ap.model.kurs.Kurs;
import com.ap.model.pohadjanje.Pohadjanje;

public class KursDTO {
	
	private Long id;
	private String naziv;
	public KursDTO() {
		super();
	}
	
	
	
	
	public KursDTO(Kurs kurs) {
		super();
		this.id = kurs.getId();
		this.naziv = kurs.getNaziv();

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
