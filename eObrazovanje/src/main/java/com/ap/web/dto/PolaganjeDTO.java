package com.ap.web.dto;

import java.util.HashSet;
import java.util.Set;

import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.predispitnaObaveza.PredispitnaObaveza;

public class PolaganjeDTO {

	
	private Long id;
	private Set<PredsipitnaObavezaDTO> predispitneObaveze = new HashSet<PredsipitnaObavezaDTO>();
	private double brojBodova;
	private int ocena;
	
	public PolaganjeDTO(PolaganjeIspita polaganjeIspita) {
		super();
		this.id = polaganjeIspita.getId();
		for (PredispitnaObaveza predispitnaObaveza : polaganjeIspita.getPredispitneObaveze()) {
			PredsipitnaObavezaDTO predsipitnaObavezaDTO = new PredsipitnaObavezaDTO(predispitnaObaveza);
			this.predispitneObaveze.add(predsipitnaObavezaDTO);
		}
		
		this.brojBodova = polaganjeIspita.getBrojBodova();
		this.ocena = polaganjeIspita.getOcena();
	}
	public PolaganjeDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PredsipitnaObavezaDTO> getPredispitneObaveze() {
		return predispitneObaveze;
	}
	public void setPredispitneObaveze(Set<PredsipitnaObavezaDTO> predispitneObaveze) {
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
