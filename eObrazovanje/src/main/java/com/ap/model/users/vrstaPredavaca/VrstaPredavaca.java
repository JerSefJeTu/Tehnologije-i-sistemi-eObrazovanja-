package com.ap.model.users.vrstaPredavaca;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ap.model.users.predavac.Predavac;
@Entity
public class VrstaPredavaca {

	private String naziv;
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="vrstaPredavaca")
	private Set<Predavac> predavaci=new HashSet<Predavac>();
	
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
