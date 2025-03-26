import java.util.*;

public class Binary {
    public static String binary(int n) {
        if (n == 0) {
            return "0"; 
        }
        return binaryHelper(n);
    }

    private static String binaryHelper(int n) {
        if (n == 0) {
            return "";
        } else {
            return binaryHelper(n / 2) + (n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(binary(n));
        scan.close();
    }
}
