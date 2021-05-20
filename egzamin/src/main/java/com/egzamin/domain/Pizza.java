package com.egzamin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
    private String nazwap;
	@Column
    private String skladniki;
	@Column
    private float cena;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwap() {
		return nazwap;
	}
	public void setNazwap(String nazwap) {
		this.nazwap = nazwap;
	}
	public String getSkladniki() {
		return skladniki;
	}
	public void setSkladniki(String skladniki) {
		this.skladniki = skladniki;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}
}

