package lab.oxgame.dao;

import java.util.List;
import lab.oxgame.model.rozgrywka;

public interface RozgrywkaDAO {
	int zapiszRozgrywke(rozgrywka rozgrywka);
	List<rozgrywka> pobierzRozgrywki(Integer odWiersza, Integer liczbaWierszy);
	int usunRozgrywki();
}
