package aplikacja;


import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
			
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 1000000; i++) {
			list.add(UUID.randomUUID().toString());
		}
		
		System.out.println("Przetwarzanie sekwencyjne");
		Instant startS = Instant.now();
		list.stream().sorted().collect(Collectors.toList());
		Instant endS = Instant.now();
		System.out.println("Czas wykonania sekwencyjnego: "+ Duration.between(startS, endS).toMillis()+ " ms");
		
		System.out.println("Przetwarzanie równoleg³e");
		Instant startR = Instant.now();
		list.parallelStream().sorted().collect(Collectors.toList());
		Instant endR = Instant.now();
		System.out.println("Czas wykonania równoleg³ego: "+ Duration.between(startR, endR).toMillis()+ " ms");
	}
}
