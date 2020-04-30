import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {
    public static void printTravelPrices(int[][] travelPrices, int numberOfCities){
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<numberOfCities; j++){
                System.out.print(travelPrices[i][j]);
                if(travelPrices[i][j]/10 == 0)
                    System.out.print("  ");
                else
                    System.out.print(' ');
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
    	Scanner data = new Scanner(System.in);
    	System.out.println("Podaj ilosc miejscowosci");
        int numberOfCities = data.nextInt();
        int[][] travelPrices = new int[numberOfCities][numberOfCities];
        for(int i = 0; i<numberOfCities; i++){
            for(int j=0; j<=i; j++){
                Random rand = new Random();
                if(i==j)
                    travelPrices[i][j] = 0;
                else {
                    travelPrices[i][j] = rand.nextInt(100);
                    travelPrices[j][i] = travelPrices[i][j];
                }
            }
        }

        printTravelPrices(travelPrices,numberOfCities);
        Instant start = Instant.now();
        Traveler geneticAlgorithm = new Traveler(numberOfCities, SelectionType.TOURNAMENT, travelPrices, 0, 0);
        Genom result = geneticAlgorithm.optimize();
        Instant end = Instant.now();
        System.out.println(result);
        System.out.println("Czas wykonania: " + Duration.between(start, end).toMillis()+ " ms");
        data.close();
    }
}

