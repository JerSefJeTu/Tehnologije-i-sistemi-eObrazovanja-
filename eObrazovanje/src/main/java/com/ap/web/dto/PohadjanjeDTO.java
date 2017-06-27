package com.ap.web.dto;

import com.ap.model.kurs.Kurs;
import com.ap.model.pohadjanje.Pohadjanje;
import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.users.student.Student;

public class PohadjanjeDTO {
	
	private Long id;
	
	
	private KursDTO kurs;
	
	private StudentDTO student;
	
	
	private PolaganjeDTO polaganje;
	


	public PohadjanjeDTO(Pohadjanje pohadjanje) {
		super();
		this.id = pohadjanje.getId();
		this.kurs = new KursDTO(pohadjanje.getKurs()); 
		this.student = new StudentDTO(pohadjanje.getStudent());
		this.polaganje = new PolaganjeDTO(pohadjanje.getPolaganje());
	}


	public PohadjanjeDTO() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public KursDTO getKurs() {
		return kurs;
	}


	public void setKurs(KursDTO kurs) {
		this.kurs = kurs;
	}


	public StudentDTO getStudent() {
		return student;
	}


	public void setStudent(StudentDTO student) {
		this.student = student;
	}


	public PolaganjeDTO getPolaganje() {
		return polaganje;
	}


	public void setPolaganje(PolaganjeDTO polaganje) {
		this.polaganje = polaganje;
	}



	
	

}
