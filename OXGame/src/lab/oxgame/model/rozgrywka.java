package lab.oxgame.model;

import java.time.LocalDateTime;

import lab.oxgame.engine.OXEnum;

public class rozgrywka {
	private Integer rozgrywkaId;
	private OXEnum zwyciezca;
	private String graczX;
	private String graczO;
	private LocalDateTime dataczasRozgrywki;
	
	public rozgrywka() {
	}

	public rozgrywka(Integer rozgrywkaId, String graczO, String graczX, OXEnum zwyciezca, LocalDateTime dataczasRozgrywki) {
		this.graczO = graczO;
		this.graczX = graczX;
		this.zwyciezca = zwyciezca;
		this.dataczasRozgrywki = dataczasRozgrywki;
		this.rozgrywkaId = rozgrywkaId;
	}
	public rozgrywka(String graczO, String graczX, OXEnum zwyciezca, LocalDateTime dataczasRozgrywki) {
		this.graczO = graczO;
		this.graczX = graczX;
		this.zwyciezca = zwyciezca;
		this.dataczasRozgrywki = dataczasRozgrywki;
	}

	public Integer getRozgrywkaId() {
		return rozgrywkaId;
	}

	public void setRozgrywkaId(Integer rozgrywkaId) {
		this.rozgrywkaId = rozgrywkaId;
	}

	public OXEnum getZwyciezca() {
		return zwyciezca;
	}

	public void setZwyciezca(OXEnum zwyciezca) {
		this.zwyciezca = zwyciezca;
	}

	public String getGraczX() {
		return graczX;
	}

	public void setGraczX(String graczX) {
		this.graczX = graczX;
	}

	public String getGraczO() {
		return graczO;
	}

	public void setGraczO(String graczO) {
		this.graczO = graczO;
	}

	public LocalDateTime getDataczasRozgrywki() {
		return dataczasRozgrywki;
	}

	public void setDataczasRozgrywki(LocalDateTime dataczasRozgrywki) {
		this.dataczasRozgrywki = dataczasRozgrywki;
	}
	
}

