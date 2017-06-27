package com.ap.web.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ap.model.kurs.Kurs;
import com.ap.model.predmet.Predmet;
import com.ap.model.users.predavac.Predavac;
import com.ap.model.users.vrstaPredavaca.VrstaPredavaca;

public class PredavacDTO  {

	private Long id;
	
	private String firstname;
	private String lastname;
	private Long JMBG;
	private String username;
	private Date dateOfBirth;
	private String placeOfOrigin;
	private String currentAddress;
	private String phoneNumber;
	private String email;
	
	private Set<KursDTO> kursevi = new HashSet<KursDTO>();

	private Set<PredmetDto> predmeti = new HashSet<PredmetDto>();

	private VrstaPredavaca vrstaPredavaca;
	private boolean aktivan;
	
	
	
	public PredavacDTO(Predavac predavac) {
		super();
		this.id = predavac.getId();
		
		this.firstname = predavac.getFirstName();
		this.lastname = predavac.getLastName();
		JMBG = predavac.getJMBG();
		this.username = predavac.getUserName();
		this.dateOfBirth = predavac.getDateOfBirth();
		this.placeOfOrigin = predavac.getPlaceOfOrigin();
		this.currentAddress = predavac.getCurrentAddress();
		this.phoneNumber = predavac.getPhoneNumber();
		this.email = predavac.geteMail();
		for (Kurs kurs : predavac.getKursevi()) {
			KursDTO kursDTO = new KursDTO(kurs);
			this.kursevi.add(kursDTO);
		}
		for (Predmet predmet : predavac.getPredmeti()) {
			PredmetDto predmetDto = new PredmetDto(predmet);
			this.predmeti.add(predmetDto);
		}
		
		
		this.vrstaPredavaca = predavac.getVrstaPredavaca();
		this.aktivan = predavac.isAktivan();
	}
	public PredavacDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getJMBG() {
		return JMBG;
	}
	public void setJMBG(Long jMBG) {
		JMBG = jMBG;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}
	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<KursDTO> getKursevi() {
		return kursevi;
	}
	public void setKursevi(Set<KursDTO> kursevi) {
		this.kursevi = kursevi;
	}
	public Set<PredmetDto> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(Set<PredmetDto> predmeti) {
		this.predmeti = predmeti;
	}
	public VrstaPredavaca getVrstaPredavaca() {
		return vrstaPredavaca;
	}
	public void setVrstaPredavaca(VrstaPredavaca vrstaPredavaca) {
		this.vrstaPredavaca = vrstaPredavaca;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
	
}
