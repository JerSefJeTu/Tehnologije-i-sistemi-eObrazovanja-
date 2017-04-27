package com.ap.model.pohadjanje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ap.model.kurs.Kurs;
import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.users.student.Student;
@Entity
public class Pohadjanje {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Kurs kurs;
	@ManyToOne
	private Student student;
	
	@OneToOne
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
