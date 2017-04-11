package com.ap.model.workEntities;

import java.util.Set;

public class PolaganjeIspita {

	private Long id;
	private Set<PredispitnaObaveza> predispitneObaveze;
	private double brojBodova;
	private int ocena;
	
	public PolaganjeIspita(){
		
	}

	public PolaganjeIspita(Long id, Set<PredispitnaObaveza> predispitneObaveze, double brojBodova, int ocena) {
		super();
		this.id = id;
		this.predispitneObaveze = predispitneObaveze;
		this.brojBodova = brojBodova;
		this.ocena = ocena;
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
