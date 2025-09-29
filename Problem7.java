import java.util.*;
import java.io.*;

public class Problem7 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reads the first line of input containing words
        String input = reader.readLine(); 
        String[] words = input.split(" "); // Splits the words into an array

        // Reads the second line of input containing numbers
        String newinput = reader.readLine(); 
        String[] numbers = newinput.split(" "); // Splits the numbers into an array
        int[] actual = new int[3]; // Array to store numerical values

        // Parses numbers from the input
        for (int i = 0; i < actual.length; i++) {
            actual[i] = Integer.parseInt(numbers[i]);
        }

        // Check if the sum of the first two numbers equals the third
        if (actual[0] + actual[1] != actual[2]) {
            System.out.println(input + "\n" + newinput + "\nBAD");
            return;
        }

        // Array to store letter-to-digit mapping (-1 indicates unused letters)
        int[] letterToDigit = new int[26];
        Arrays.fill(letterToDigit, -1);
        boolean[] digitUsed = new boolean[10]; // Tracks used digits (0-9)

        boolean isValid = true; // Flag to determine validity
        
        // Validate letter-to-digit mapping across words and numbers
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String numStr = numbers[i];
            
            // Check if word and corresponding number have the same length
            if (word.length() != numStr.length()) {
                isValid = false;
                break;
            }
            
            for (int j = 0; j < word.length(); j++) {
                char letter = word.charAt(j);
                int digit = numStr.charAt(j) - '0';
                int letterIndex = letter - 'A';
                
                // If letter is already mapped, ensure consistency
                if (letterToDigit[letterIndex] != -1 && letterToDigit[letterIndex] != digit) {
                    isValid = false;
                    break;
                }
                
                // Ensure no duplicate digit mapping to different letters
                if (!digitUsed[digit] && letterToDigit[letterIndex] == -1) {
                    letterToDigit[letterIndex] = digit;
                    digitUsed[digit] = true;
                } else if (letterToDigit[letterIndex] != digit) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) break;
        }

        // Check for leading zeros in multi-digit numbers
        for (int i = 0; i < words.length; i++) {
            if (numbers[i].length() > 1 && numbers[i].charAt(0) == '0') {
                isValid = false;
                break;
            }
        }

        // Output result
        System.out.println(input + "\n" + newinput + "\n" + (isValid ? "GOOD" : "BAD"));
    }
}
