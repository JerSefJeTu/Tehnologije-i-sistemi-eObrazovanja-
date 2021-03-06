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

import com.ap.model.kurs.Kurs;
import com.ap.model.polaganjeIspita.PolaganjeIspita;
import com.ap.model.users.predavac.Predavac;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PredispitnaObaveza {
	@Id
	@GeneratedValue
	private Long id;
	private Date datumPolaganja;
	private boolean polozio;
	private String nazivObaveze;
	
	@ManyToOne
	private Kurs kurs;
	
	@ManyToMany(cascade =CascadeType.MERGE)
	@JoinTable(name = "predispitna_predavac", joinColumns = { @JoinColumn(name = "predispitna_id") }, inverseJoinColumns = { @JoinColumn(name = "predavac_id") })
	@JsonIgnore
	private Set<Predavac> dezurniPredavaci=new HashSet<Predavac>();
	
	private double brojBodova;
	
	private double minBodova;
	private double maxbodova;
	@ManyToOne
	@JsonIgnore
	private PolaganjeIspita polaganjeIspita;
	
	public PredispitnaObaveza(){
		
	}


	
	

	public PredispitnaObaveza(Long id, Date datumPolaganja, boolean polozio, String nazivObaveze, Kurs kurs,
			Set<Predavac> dezurniPredavaci, double brojBodova, double minBodova, double maxbodova,
			PolaganjeIspita polaganjeIspita) {
		super();
		this.id = id;
		this.datumPolaganja = datumPolaganja;
		this.polozio = polozio;
		this.nazivObaveze = nazivObaveze;
		this.kurs = kurs;
		this.dezurniPredavaci = dezurniPredavaci;
		this.brojBodova = brojBodova;
		this.minBodova = minBodova;
		this.maxbodova = maxbodova;
		this.polaganjeIspita = polaganjeIspita;
	}

	




	public PredispitnaObaveza(PredispitnaObaveza predispitnaObaveza) {
		this.id=null;
		this.datumPolaganja = predispitnaObaveza.getDatumPolaganja();
		this.polozio = predispitnaObaveza.isPolozio();
		this.nazivObaveze = predispitnaObaveza.getNazivObaveze();
		this.brojBodova = predispitnaObaveza.getBrojBodova();
		this.minBodova = predispitnaObaveza.getMinBodova();
		this.maxbodova = predispitnaObaveza.getMaxbodova();
		this.polaganjeIspita = predispitnaObaveza.getPolaganjeIspita();
	}





	public double getMaxbodova() {
		return maxbodova;
	}

	public void setMaxbodova(double maxbodova) {
		this.maxbodova = maxbodova;
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

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}
	
	
	
}
