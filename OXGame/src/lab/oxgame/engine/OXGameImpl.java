package lab.oxgame.engine;

public class OXGameImpl implements OXGame {
	private OXEnum kolej;
	private OXEnum zwyciezca;
	private OXEnum[] stan;
	private int krok;
	private Boolean wygrana;
	
	public OXGameImpl() {
		inicjalizuj();
	}
	@Override
	public void inicjalizuj() {
		krok = 0;
		zwyciezca = OXEnum.BRAK;
		kolej = Math.random()<0.5 ? OXEnum.O : OXEnum.X;
		stan = new OXEnum[] {
				OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK,
				OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK,
				OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK};
		}
		

	@Override
	public void setPole(int indeks) {
		stan[indeks] = kolej;
		sprawdzPola();
		
	}

	@Override
	public OXEnum getPole(int indeks) {
		// TODO Auto-generated method stub
		return stan[indeks];
	}

	@Override
	public OXEnum getKolej() {
		// TODO Auto-generated method stub
		return kolej;
	}

	@Override
	public OXEnum getZwyciezca() {
		// TODO Auto-generated method stub
		return zwyciezca;
	}

	@Override
	public int[] getIndeksyZwyciezcy() {
		// TODO Auto-generated method stub
		return null;
	}
	private void sprawdzPola() {
		krok += 1;
		boolean koniec = krok > 8;
		wygrana = ((kolej.equals(stan[0])&&kolej.equals(stan[4])&&kolej.equals(stan[8]))
				|| (kolej.equals(stan[0])&&kolej.equals(stan[1])&&kolej.equals(stan[2]))
				|| (kolej.equals(stan[3])&&kolej.equals(stan[4])&&kolej.equals(stan[5]))
				|| (kolej.equals(stan[6])&&kolej.equals(stan[7])&&kolej.equals(stan[8]))
				|| (kolej.equals(stan[2])&&kolej.equals(stan[4])&&kolej.equals(stan[6]))
				|| (kolej.equals(stan[0])&&kolej.equals(stan[3])&&kolej.equals(stan[6]))
				|| (kolej.equals(stan[1])&&kolej.equals(stan[4])&&kolej.equals(stan[7]))
				|| (kolej.equals(stan[2])&&kolej.equals(stan[5])&&kolej.equals(stan[8]))
				);	
		if(wygrana) {
			zwyciezca = kolej;
			kolej = OXEnum.BRAK;
		}else if(koniec) {
			kolej = OXEnum.BRAK;
		}else {
			kolej = kolej == OXEnum.O ? OXEnum.X : OXEnum.O;
		}
	}	
}
