import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int myfavnum = 7;
        int userfavnum;
       
        // Taking user input
        Scanner favnum = new Scanner(System.in);
        System.out.println("Enter your favorite number: ");
        userfavnum = favnum.nextInt();

        // Comparing favorite numbers
        if (myfavnum == userfavnum) {
            System.out.println("Your favorite number is my favorite number🥳!!!");
        } else if (myfavnum < userfavnum) {
            System.out.println("Your favorite number is greater than my favorite number 7. 🥹");
        } else {
            System.out.println("Your favorite number is less than my favorite number 7. 😋");
        }
    }
}