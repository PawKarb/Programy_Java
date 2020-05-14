package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ServerController {
	@FXML
	private TextArea quizarea_server; 
    
    private BlockingQueue<Socket> blockingQueue;
    private int licznik;
    private Iterator<Entry<String,String>> iterator;
    private Entry<String ,String> current;
    
    public void initialize() throws FileNotFoundException {
    	quizarea_server.setEditable(false);
    	this.readFile();
		serverThread.start();
    }

	public void setBlockingQueue(BlockingQueue<Socket> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	

	Thread serverThread = new Thread(){
		public void run() {
			try(ServerSocket server = new ServerSocket(6545)) {
				while(true) {
					Socket serverSocket = server.accept();
					blockingQueue.put(serverSocket);
				}
			} catch (IOException | InterruptedException e) {
					e.printStackTrace();
					System.exit(0);
			}
			}
		};
		
	public void nextQuestion() {
		if(this.iterator.hasNext())
			current = iterator.next();
		this.licznik--;
	}
	public String getAnswer() {
		return current.getKey();
	}	
	public String getQuestion() {
		return current.getValue();
	}
	public void console(String s) {
		quizarea_server.appendText(s + "\n");
	}
		
	private void readFile() throws FileNotFoundException {
		String pytanie;
		String odpowiedz;

		File plik = new File("pytania_odp.txt");
		Scanner skaner = new Scanner(plik);
		HashMap<String, String> pytanieOdpowiedz = new HashMap<String, String>();
		
		while(skaner.hasNext()) {
				skaner.useDelimiter("[|]");
				pytanie = skaner.next();
				odpowiedz = skaner.next();
				pytanieOdpowiedz.put(odpowiedz, pytanie);
		}
		skaner.close();
		this.licznik = pytanieOdpowiedz.size();
		iterator = pytanieOdpowiedz.entrySet().iterator();
		nextQuestion();
		this.console("Pytanie " + (licznik + 1) +": \n" + getQuestion());
	}
	public void startProcess() {
	 Thread process = new Thread(new Runnable() {
		private Socket socket;
		
		@Override
		public void run() {
			try {
				while (licznik >= 0) {
					socket = blockingQueue.take();
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
					Answer answer = ((Answer) in.readObject());
					
					if(answer.getOdpowiedz().equalsIgnoreCase(getAnswer())) {
						console("U¿ytkownik o nicku: {" + answer.getNick() + "} odpowiedzia³(a) poprawnie");
						nextQuestion();
						console("");
						if(licznik >= 0) {
							console("Pytanie " + (licznik + 1) +": " + getQuestion());
						}
					}else {
						console("Nadesz³a b³êdna odpowiedz!!!");
					}
				}//while
			} catch (InterruptedException | IOException | ClassNotFoundException e) {
				
			}
			console("\nOdpowiedziano ju¿ na wszystkie pytnia");
		}
	});
	 process.start();
	}
}
