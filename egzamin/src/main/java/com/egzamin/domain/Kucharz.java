package com.egzamin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Kucharz {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	@ForeignKey(name = "id")
    private int numerZamowienia;
	@Column
    private String nazwaPizzy;
	@Column
    private int ilosc;
	@Column
	private boolean czyGotowe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumerZamowienia() {
		return numerZamowienia;
	}
	public void setNumerZamowienia(int numerZamowienia) {
		this.numerZamowienia = numerZamowienia;
	}
	public String getNazwaPizzy() {
		return nazwaPizzy;
	}
	public void setNazwaPizzy(String nazwaPizzy) {
		this.nazwaPizzy = nazwaPizzy;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	public boolean isCzyGotowe() {
		return czyGotowe;
	}
	public void setCzyGotowe(boolean czyGotowe) {
		this.czyGotowe = czyGotowe;
	}
	
	
}

