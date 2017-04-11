package com.ap.model.workEntities;

import com.ap.model.users.Student;

public class Pohadjanje {

	private Long id;
	private Kurs kurs;
	private Student student;
	private PolaganjeIspita polaganje;
	
	public Pohadjanje(){
		
	}
	
	public Pohadjanje(Long id, Kurs kurs, Student student, PolaganjeIspita polaganje) {
		super();
		this.id = id;
		this.kurs = kurs;
		this.student = student;
		this.polaganje = polaganje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PolaganjeIspita getPolaganje() {
		return polaganje;
	}

	public void setPolaganje(PolaganjeIspita polaganje) {
		this.polaganje = polaganje;
	}
	
	
}
