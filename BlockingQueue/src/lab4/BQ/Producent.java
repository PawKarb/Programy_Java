package lab4.BQ;

import java.util.concurrent.BlockingQueue;

public class Producent implements Runnable {
	private BlockingQueue<Produkt> kolejka;
	private Produkt produkt;
	Producent(BlockingQueue<Produkt> kolejka){
		this.kolejka = kolejka;
	}
	public void run() {
		for(int i=0; i<=10; i++) {
			produkt = new Produkt("Produkt "+i);
		try {
			Thread.sleep(500);
			kolejka.put(produkt);
			System.out.println("Producent wykona³ " + produkt.getProdukt()+" !");
		}catch(InterruptedException e) {}
		}//for
		produkt = new Produkt("brak");
		try {
			kolejka.put(produkt);
		}catch(InterruptedException e) {}
	}
}
