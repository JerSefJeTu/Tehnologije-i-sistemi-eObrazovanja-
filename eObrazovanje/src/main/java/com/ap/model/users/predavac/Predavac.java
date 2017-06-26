package com.ap.model.users.predavac;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.ap.model.kurs.Kurs;
import com.ap.model.predispitnaObaveza.PredispitnaObaveza;
import com.ap.model.predmet.Predmet;
import com.ap.model.users.korisnik.Korisnik;
import com.ap.model.users.vrstaPredavaca.VrstaPredavaca;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@DiscriminatorValue("PREDAVAC")
@PrimaryKeyJoinColumn(name = "KORISNIK_ID")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Predavac extends Korisnik {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "predavac_kursevi", joinColumns = { @JoinColumn(name = "predavac_id") }, inverseJoinColumns = {
			@JoinColumn(name = "kurs_id") })
	private Set<Kurs> kursevi = new HashSet<Kurs>();
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "predavac_predmeti", joinColumns = { @JoinColumn(name = "predavac_id") }, inverseJoinColumns = {
			@JoinColumn(name = "predmet_id") })
	private Set<Predmet> predmeti = new HashSet<Predmet>();

	@ManyToOne
	private VrstaPredavaca vrstaPredavaca;
	private boolean aktivan;

	@ManyToMany(mappedBy = "dezurniPredavaci", fetch = FetchType.LAZY)
	private Set<PredispitnaObaveza> predispitneObaveze = new HashSet<PredispitnaObaveza>();

	public Predavac() {
		super();
	}

	public Predavac(String firstName, String lastName, Long jMBG, String userName, String password, Date dateOfBirth,
			String placeOfOrigin, String currentAddress, String phoneNumber, String eMail,
			PredispitnaObaveza predispitnaObaveza) {
		super(firstName, lastName, jMBG, userName, password, dateOfBirth, placeOfOrigin, currentAddress, phoneNumber,
				eMail);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(Set<Kurs> kursevi) {
		this.kursevi = kursevi;
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

	public Set<PredispitnaObaveza> getPredispitneObaveze() {
		return predispitneObaveze;
	}

	public void setPredispitneObaveze(Set<PredispitnaObaveza> predispitneObaveze) {
		this.predispitneObaveze = predispitneObaveze;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	

}
