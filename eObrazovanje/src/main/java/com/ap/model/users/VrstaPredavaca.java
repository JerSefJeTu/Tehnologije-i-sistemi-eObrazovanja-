package com.ap.model.users;

public class VrstaPredavaca {

	private String naziv;
	private Long id;
	
	public VrstaPredavaca(){
		
	}
	
	public VrstaPredavaca(String naziv, Long id) {
		super();
		this.naziv = naziv;
		this.id = id;
	}

	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
