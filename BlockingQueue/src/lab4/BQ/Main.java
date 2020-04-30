package lab4.BQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Produkt> kolejka = new ArrayBlockingQueue<>(2);
		Producent producent = new Producent(kolejka);
		Konsument konsument = new Konsument(kolejka);
		new Thread(producent).start();
		new Thread(konsument).start();
		System.out.println("Producent i Konsument uruchomieni!");
	}

}
