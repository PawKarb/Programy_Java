package com.egzamin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
    private String imie;
	@Column
    private String nazwaPizzy;
	@Column
	private int ilosc;
	@Column
    private float cena;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
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
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
	
	
}
