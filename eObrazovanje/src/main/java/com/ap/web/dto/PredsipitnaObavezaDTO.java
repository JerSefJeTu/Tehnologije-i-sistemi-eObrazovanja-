package com.ap.web.dto;

import java.util.Date;

import com.ap.model.predispitnaObaveza.PredispitnaObaveza;
public class PredsipitnaObavezaDTO {

	private Long id;
	private Date datumPolaganja;
	private boolean polozio;
	private String nazivObaveze;
	private double brojBodova;
	private double minBodova;
	private double maxBodova;
	private KursDTO kurs;
	
	
	public PredsipitnaObavezaDTO() {
		super();
	}
	public PredsipitnaObavezaDTO(PredispitnaObaveza predispitnaObaveza) {
		super();
		this.id = predispitnaObaveza.getId();
		this.datumPolaganja = predispitnaObaveza.getDatumPolaganja();
		this.polozio =predispitnaObaveza.isPolozio();
		this.nazivObaveze = predispitnaObaveza.getNazivObaveze();
		this.brojBodova = predispitnaObaveza.getBrojBodova();
		this.minBodova = predispitnaObaveza.getMinBodova();
		this.maxBodova=predispitnaObaveza.getMaxbodova();
		this.kurs=new KursDTO(predispitnaObaveza.getKurs());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	public boolean isPolozio() {
		return polozio;
	}
	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}
	public String getNazivObaveze() {
		return nazivObaveze;
	}
	public void setNazivObaveze(String nazivObaveze) {
		this.nazivObaveze = nazivObaveze;
	}
	public double getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}
	public double getMinBodova() {
		return minBodova;
	}
	public void setMinBodova(double minBodova) {
		this.minBodova = minBodova;
	}
	public double getMaxBodova() {
		return maxBodova;
	}
	public void setMaxBodova(double maxBodova) {
		this.maxBodova = maxBodova;
	}
	public KursDTO getKurs() {
		return kurs;
	}
	public void setKurs(KursDTO kurs) {
		this.kurs = kurs;
	}
	
	
	
	
}
