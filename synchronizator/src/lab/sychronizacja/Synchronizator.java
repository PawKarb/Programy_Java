package lab.sychronizacja;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class Synchronizator {
	
	private AtomicBoolean monitor;
	public Synchronizator() {
		monitor = new AtomicBoolean(true);
		start();
	}
	
	private void start() {
		Runnable task = () -> {
			while(monitor.get()) {
				
				synchronizuj();
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e ) {
					System.out.println("Oczekiwanie przerwane!");
				}
			}
		};
		
		Thread worker = new Thread(task);
		worker.start();	
	}
	
	public void stop() {
		monitor.set(false);
	}
	
	private void synchronizuj() {
		try {
			Path pathA = Paths.get("A");
			Path pathB = Paths.get("B");
			
			boolean existsA = Files.exists(pathA);
			
			boolean isDirectoryA = Files.isDirectory(pathA);
			
			File dirA = pathA.toFile();
			File dirB = pathA.toFile();
			
			String[] listA = dirA.list();
			String[] listB = dirB.list();
			
			// wyszukiwanie plikow do kopiowania
			
			for (String elementA : listA) {
				boolean istnieje = false;
				for (String elementB : listB)  {
					istnieje = elementA.equals(elementB);
					if (istnieje)
						break;
				}
					
				if (!istnieje) {
					// kopiowanie pliku
					String fileToCopy = elementA;
					Path src = Paths.get(pathA.toString(), fileToCopy);
					Path dst = Paths.get(pathB.toString(), fileToCopy);
					
					if (!Files.isDirectory(src)) {
						Files.copy(src, dst);
						System.out.println("Skopiowany plik " + fileToCopy);				
					} else {
						Files.createDirectory(dst);
					}
				}		
			}
			
		
			
			// wyszukiwanie plikow do usuneicia
			
			for (String elementB : listB) {
				boolean istnieje = false;
				for (String elementA : listA)  {
					istnieje = elementA.equals(elementB);
					if (istnieje)
						break;
				}
					
				if (!istnieje) {
					// Usuwanie pliku
					String fileToDelete = elementB;
					Path file = Paths.get(pathB.toString(), fileToDelete);
					Files.delete(file);
					System.out.println("Usunieto plik " + fileToDelete);
				}		
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}