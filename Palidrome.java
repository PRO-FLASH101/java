import java.util.*; 

public class Palidrome{
    public static String isPalidrome(String phrase){
        if(phrase.length() == 1){
            return phrase;
        }
        else{
            return isPalidrome(phrase.substring(1)) + phrase.charAt(0);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String phrase = scan.nextLine();
        String reversedPhrase = isPalidrome(phrase);
        if(phrase.equalsIgnoreCase(reversedPhrase)){
            System.out.println("The phrase is a palidrome");
        }
        else{
            System.out.println("The phrase is not a palidrome");
        }

        scan.close();
        
    }
}
