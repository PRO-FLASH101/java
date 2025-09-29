import java.util.*;

public class temp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // Number of stops
        int[] stops = new int[N];

        // Reading the number of passengers at each stop
        for (int i = 0; i < N; i++) {
            stops[i] = scan.nextInt();
        }

        // Initialize variables for time and passenger count
        int timeA = 0, timeB = 0;
        int passengersA = 0, passengersB = 0;

        // Start from the two ends of the bus route
        int i = 0, j = N - 1;

        // Simulation until the buses meet
        while (i <= j) {
            if (timeA <= timeB) {
                timeA += stops[i]; // Bus A picks up all passengers at stop i
                passengersA += stops[i]; // Add passengers to Bus A
                i++; // Move to the next stop for Bus A
            } else {
                timeB += stops[j]; // Bus B picks up all passengers at stop j
                passengersB += stops[j]; // Add passengers to Bus B
                j--; // Move to the next stop for Bus B
            }
        }

        // Output the stop where they meet, the time, and the passenger counts
        System.out.println(i + " " + timeA + " " + passengersA + " " + passengersB);

        scan.close();
    }
}
