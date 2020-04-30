package lab.oxgame.engine;

public interface OXGame {
	void inicjalizuj();
	void setPole(int indeks);
	OXEnum getPole(int indeks);
	OXEnum getKolej();
	OXEnum getZwyciezca();
	int[] getIndeksyZwyciezcy();
}
