import java.util.*;

public class TransfinderProblem {
    static List<String> solutions = new ArrayList<>();
    
    public static void findExpressions(String expr, int index, int currentSum, int lastValue, int target) {
        if (index == 10) { // All digits have been used (index starts from 1)
            if (currentSum == target) {
                solutions.add(expr);
            }
            return;
        }
        
        // Form numbers by concatenation
        int num = 0;
        for (int i = index; i <= 9; i++) {
            num = num * 10 + i; // Form the next number
            
            if (index == 1) {
                // First number, start new expression
                findExpressions(expr + num, i + 1, num, num, target);
            } else {
                // Try addition
                findExpressions(expr + "+" + num, i + 1, currentSum + num, num, target);
                
                // Try subtraction
                findExpressions(expr + "-" + num, i + 1, currentSum - num, -num, target);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target value: ");
        int target = scanner.nextInt();
        scanner.close();
        
        solutions.clear();
        findExpressions("", 1, 0, 0, target);
        
        if (solutions.isEmpty()) {
            System.out.println("NO SOLUTIONS FOUND");
        } else {
            for (String solution : solutions) {
                System.out.println(solution);
            }
        }
    }
}
