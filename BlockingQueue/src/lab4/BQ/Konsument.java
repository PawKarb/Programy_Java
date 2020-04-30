package lab4.BQ;

import java.util.concurrent.BlockingQueue;

public class Konsument implements Runnable {
	private BlockingQueue<Produkt> kolejka;
	private Produkt produkt;
	
	public Konsument(BlockingQueue<Produkt> kolejka) {
		this.kolejka = kolejka;
	}

	@Override
	public void run() {
		try {
			while(!(produkt = kolejka.take()).getProdukt().equals("brak")) {
				Thread.sleep(2500);
				System.out.println("*Konsument odebra³ "+produkt.getProdukt()+"*");
			}
		}catch (InterruptedException e) {
			System.out.println("\nProdukcja zakoñczona");
		}
	}
	
}
