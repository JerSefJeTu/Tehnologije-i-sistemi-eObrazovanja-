package com.ap.web.dto;



import com.ap.model.dokument.Dokument;


public class DokumentDTO {

	private Long id;
	
	private String naziv;
	
	private StudentDTO student;
	
	

	public DokumentDTO(Dokument dokument) {
		super();
		this.id = dokument.getId();
		this.naziv = dokument.getNaziv();
		this.student = new StudentDTO(dokument.getStudent());
	}

	public DokumentDTO() {
		super();
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

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	
	
}
