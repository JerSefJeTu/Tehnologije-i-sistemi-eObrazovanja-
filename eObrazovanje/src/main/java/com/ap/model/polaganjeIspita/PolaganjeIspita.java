package com.ap.model.polaganjeIspita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.predispitnaObaveza.PredispitnaObaveza;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PolaganjeIspita {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy="polaganjeIspita")
	private Set<PredispitnaObaveza> predispitneObaveze = new HashSet<PredispitnaObaveza>();
	private double brojBodova;
	private int ocena;
	@OneToOne(mappedBy="polaganje")
	@JsonIgnore
	private Pohadjanje pohadjanje;
	
	public PolaganjeIspita(){
		
	}

	public PolaganjeIspita(Long id, Set<PredispitnaObaveza> predispitneObaveze, double brojBodova, int ocena,Pohadjanje pohadjanje) {
		super();
		this.id = id;
		this.predispitneObaveze = predispitneObaveze;
		this.brojBodova = brojBodova;
		this.ocena = ocena;
		this.pohadjanje=pohadjanje;
	}
	
	

	public Pohadjanje getPohadjanje() {
		return pohadjanje;
	}

	public void setPohadjanje(Pohadjanje pohadjanje) {
		this.pohadjanje = pohadjanje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<PredispitnaObaveza> getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(Set<PredispitnaObaveza> predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
	}

	public double getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
	
}
