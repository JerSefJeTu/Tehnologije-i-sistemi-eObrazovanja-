package com.ap.web.dto;

import java.util.Date;

import com.ap.model.uplata.Uplata;



public class UplataDTO {
	

	private Long id;
	private StudentDTO student;
	private double iznos;
	private String svrhaUplate;
	private Date datumUplate;
	
	
	public UplataDTO() {
		super();
	}
	public UplataDTO(Uplata uplata) {
		super();
		this.id = uplata.getId();
		this.student = new StudentDTO(uplata.getStudent());
		this.iznos = uplata.getIznos();
		this.svrhaUplate = uplata.getSvrhaUplate();
		this.datumUplate = uplata.getDatumUplate();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	public String getSvrhaUplate() {
		return svrhaUplate;
	}
	public void setSvrhaUplate(String svrhaUplate) {
		this.svrhaUplate = svrhaUplate;
	}
	public Date getDatumUplate() {
		return datumUplate;
	}
	public void setDatumUplate(Date datumUplate) {
		this.datumUplate = datumUplate;
	}

	
	
}
