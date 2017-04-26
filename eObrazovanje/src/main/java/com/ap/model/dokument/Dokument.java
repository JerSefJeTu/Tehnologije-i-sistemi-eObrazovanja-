package com.ap.model.dokument;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.ap.model.users.Student;

@Entity
public class Dokument {

	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@ManyToOne
	private Student student;
	public Dokument(){
		
	}
	
	public Dokument(Long id, String naziv,Student student) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.student=student;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
