import java.util.*;
/* 
 * This program takes a string and reverses it using recursion.
 * 
 * The reverser method takes a string as a parameter and returns a string.
 * The base case is when the string is empty, in which case the method returns an empty string.
 * Otherwise, the method returns the result of calling itself with the substring of the input string starting from the second character, concatenated with the first character of the input string.
 * 
 * The main method reads a string from the user, calls the reverser method with the input string, and prints the result.
 */
public class Practice {
    /* Reverses the input string using recursion.
     * @param phrase the string to reverse
     * @return the reversed string
    */
    public static String reverser(String phrase){
        if(phrase.length() == 0){
            return "";
        }
        else{
            return reverser(phrase.substring(1)) +  phrase.charAt(0); 
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String phrase = scan.nextLine();
        System.out.println(reverser(phrase));

        scan.close();
    }
}
