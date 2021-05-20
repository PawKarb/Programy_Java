package lab8.aplikacja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column
    private String Imie;
	@Column
    private String Nazwisko;
	@Column
    private int Wiek;
	@Column
	private String indeks;
	@Column
	private String Kierunek;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImie() {
		return Imie;
	}
	public void setImie(String imie) {
		Imie = imie;
	}
	public String getNazwisko() {
		return Nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}
	public int getWiek() {
		return Wiek;
	}
	public void setWiek(int wiek) {
		Wiek = wiek;
	}
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public String getKierunek() {
		return Kierunek;
	}
	public void setKierunek(String kierunek) {
		Kierunek = kierunek;
	}
}
