package com.ap.web.dto;

import java.util.HashSet;
import java.util.Set;



import com.ap.model.dokument.Dokument;
import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.uplata.Uplata;
import com.ap.model.users.student.Student;

public class StudentDTO {
	private Long id;
	private double stanje;
	
	private Set<Dokument> dokumenti=new HashSet<Dokument>();
	
	
	private Set<Uplata> uplate=new HashSet<Uplata>();

	
	public StudentDTO(Student student) {
		super();
		this.id= student.getId() ;
		this.stanje = student.getStanje();
		this.dokumenti = student.getDokumenti();
		this.uplate = this.getUplate();
	}

	public StudentDTO() {
		super();
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public Set<Dokument> getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(Set<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}


	public Set<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
