package com.ap.web.dto;

import java.util.HashSet;
import java.util.Set;

import com.ap.model.kurs.Kurs;
import com.ap.model.predmet.Predmet;

public class PredmetDto {

	private Long id;
	private String naziv;
	private Set<KursDTO> kursevi=new HashSet<KursDTO>();
	
	
	public PredmetDto() {
		super();
	}
	
	
	public PredmetDto(Predmet predmet) {
		super();
		this.id = predmet.getId();
		this.naziv = predmet.getNaziv();
		for (Kurs kurs : predmet.getKursevi()) {
			KursDTO kursDTO = new KursDTO(kurs);
			this.kursevi.add(kursDTO);
		}

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


	public Set<KursDTO> getKursevi() {
		return kursevi;
	}


	public void setKursevi(Set<KursDTO> kursevi) {
		this.kursevi = kursevi;
	}

	
	
}
