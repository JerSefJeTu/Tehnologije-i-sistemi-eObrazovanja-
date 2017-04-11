package com.ap.model.workEntities;

import java.util.Date;

import com.ap.model.users.Student;

public class Uplata {
	
	private Long id;
	private Student student;
	private double iznos;
	private String svrhaUplate;
	private Date datumUplate;
	
	public Uplata(){
		
	}

	public Uplata(Long id, Student student, double iznos, String svrhaUplate, Date datumUplate) {
		super();
		this.id = id;
		this.student = student;
		this.iznos = iznos;
		this.svrhaUplate = svrhaUplate;
		this.datumUplate = datumUplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
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
