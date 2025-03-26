import java.util.Scanner;

public class bases {

    // Method to convert a number 'n' into a given 'base' iteratively
    public static String base(int n, int base) {
        if (n == 0) {
            return "0"; // Special case: If n is 0, return "0"
        }

        StringBuilder result = new StringBuilder();

        while (n > 0) {
            result.append(n % base);  // Append remainder (least significant digit)
            n /= base;  // Reduce n by dividing it by the base
        }

        return result.reverse().toString(); // Reverse to get the correct order
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Read input number
        int n = scan.nextInt();
        scan.close(); // Close scanner to save resources

        boolean found = false; // Flag to check if we found any monodigit number

        // Iterate through bases from 2 to 10
        for (int base = 2; base <= 10; base++) {
            String convertedNumber = base(n, base); // Convert n to current base
            
            // Check if all characters in convertedNumber are the same
            boolean isMonoDigit = true;
            for (int j = 1; j < convertedNumber.length(); j++) {
                if (convertedNumber.charAt(j) != convertedNumber.charAt(0)) {
                    isMonoDigit = false;
                    break; // Stop checking as soon as a different digit is found
                }
            }
            
            // If it's a monodigit number, print the result
            if (isMonoDigit) {
                System.out.println(n + " Base " + base + ": " + convertedNumber);
                found = true;
            }
        }

        // If no monodigit representation was found, print "NO"
        if (!found) {
            System.out.println("NO");
        }
    }
}
