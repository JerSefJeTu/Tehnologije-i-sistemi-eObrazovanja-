package com.ap.model.predispitnaObaveza;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.users.predavac.Predavac;
@Entity
public class PredispitnaObaveza {
	@Id
	@GeneratedValue
	private Long id;
	private Date datumPolaganja;
	private boolean polozio;
	private String nazivObaveze;
	
	@ManyToMany(cascade =CascadeType.MERGE)
	@JoinTable(name = "predispitna_predavac", joinColumns = { @JoinColumn(name = "predispitna_id") }, inverseJoinColumns = { @JoinColumn(name = "predavac_id") })
	private Set<Predavac> dezurniPredavaci=new HashSet<Predavac>();
	private double brojBodova;
	private double minBodova;
	@ManyToOne
	private PolaganjeIspita polaganjeIspita;
	
	public PredispitnaObaveza(){
		
	}

	public PredispitnaObaveza(Long id, Date datumPolaganja, boolean polozio, String nazivObaveze,
			Set<Predavac> dezurniPredavaci, double brojBodova, double minBodova,PolaganjeIspita polaganjeIspita) {
		super();
		this.id = id;
		this.datumPolaganja = datumPolaganja;
		this.polozio = polozio;
		this.nazivObaveze = nazivObaveze;
		this.dezurniPredavaci = dezurniPredavaci;
		this.brojBodova = brojBodova;
		this.minBodova = minBodova;
		this.polaganjeIspita=polaganjeIspita;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}

	public String getNazivObaveze() {
		return nazivObaveze;
	}

	public void setNazivObaveze(String nazivObaveze) {
		this.nazivObaveze = nazivObaveze;
	}

	public Set<Predavac> getDezurniPredavaci() {
		return dezurniPredavaci;
	}

	public void setDezurniPredavaci(Set<Predavac> dezurniPredavaci) {
		this.dezurniPredavaci = dezurniPredavaci;
	}

	public double getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}

	public double getMinBodova() {
		return minBodova;
	}

	public void setMinBodova(double minBodova) {
		this.minBodova = minBodova;
	}

	public PolaganjeIspita getPolaganjeIspita() {
		return polaganjeIspita;
	}

	public void setPolaganjeIspita(PolaganjeIspita polaganjeIspita) {
		this.polaganjeIspita = polaganjeIspita;
	}
	
	
	
}
