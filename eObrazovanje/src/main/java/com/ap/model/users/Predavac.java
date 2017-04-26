package com.ap.model.users;

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

@Entity
@DiscriminatorValue("PREDAVAC")
@PrimaryKeyJoinColumn(name = "KORISNIK_ID")
public class Predavac extends Korisnik {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "predavac_kursevi", joinColumns = { @JoinColumn(name = "predavac_id") }, inverseJoinColumns = {
			@JoinColumn(name = "kurs_id") })
	private Set<Kurs> kursevi = new HashSet<Kurs>();

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

}
