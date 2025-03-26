import java.util.*;

public class crosswordsolver{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //gets the set up
        int rows = scan.nextInt();
        int col = scan.nextInt();

        //2d array of wordpuzzle
        String[][] letters = new String[rows][col];
       
        //scans the letfover \n thing
        scan.nextLine();

        // Set the 2D array
        for (int i = 0; i < rows; i++) {
            String word = scan.nextLine();  // Read the word
            for (int j = 0; j < col; j++) {
                letters[i][j] = String.valueOf(word.charAt(j));  // Store each character in the 2D array
            }
        }

        //the number of wrods we need to find
        int num = scan.nextInt();

        String[] solutions = new String[num];
       
        //for the leftover \n
        scan.nextLine();

        for(int i = 0; i < num; i++){
            solutions[i] = scan.nextLine();
        }

        //for effiency
        scan.close();

        //gets all the results
        String up = up(letters, solutions);
        String down = down(letters, solutions);
        String right = right(letters, solutions);
        String left = left(letters, solutions); 
        String diagnol = diagnol(letters, solutions);

        //final output string
        ArrayList<String> output = new ArrayList<String>();

        //adds stuff to output
        for(int i = 0; i < solutions.length; i++){
            if(up.contains(solutions[i])){
                output.add(solutions[i] + " FOUND");
            }
            else if(down.contains(solutions[i])){
                output.add(solutions[i] + " FOUND");
            }
            else if(right.contains(solutions[i])){
                output.add(solutions[i] + " FOUND");
            }
            else if(left.contains(solutions[i])){
                output.add(solutions[i] + " FOUND");
            }
            else if(diagnol.contains(solutions[i])){
                output.add(solutions[i] + " FOUND");
            }
            else{
                output.add(solutions[i] + " NOT FOUND"); 
            }
        }

        //outputted 
        for(String s : output){
            System.out.println(s); 
        } 

    }
    public static String right(String[][] arr, String[] solutions){
        String result = ""; //stores the results for all solutions 

        for(int i = 0; i < solutions.length; i++){ //cycle through the solutions
            for(int r = 0; r < arr.length; r++){ //cycle through each row
                String s = "";  //build string of the row 
                for(int c = 0; c < arr[0].length; c++){
                    s += arr[r][c];
                }
                if(s.contains(solutions[i])){ //see if solution is there
                    result += solutions[i] + " FOUND\n";
                    break; // No need to check further for this solution  
                }
                
            }
        }

        return result.trim(); 
    }
    public static String left(String[][]arr, String[] solutions){
        String result = ""; //stores the results for all solutions 

        for(int i = 0; i < solutions.length; i++){ //cycle through the solutions
            for(int r = 0; r < arr.length; r++){ //cycle through each row
                String s = "";  //build string of the row 
                for(int c =  arr[0].length - 1; c >= 0; c--){
                    s += arr[r][c];
                }
                if(s.contains(solutions[i])){ //see if solution is there
                    result += solutions[i] + " FOUND\n";
                    break; // No need to check further for this solution                
                }
            }
        }
        return result.trim(); 
    }
    public static String down(String[][] arr, String[] solutions){
        String result = ""; //stores the results for all soultions 

        for(int i = 0; i < solutions.length; i++){ //cycle through the solutions
            for(int c = 0; c < arr[0].length; c++){ //cycle through each row
                String s = "";  //build string of the row 
                for(int r =  0; r < arr.length; r++){
                    s += arr[r][c];
                }
                if(s.contains(solutions[i])){ //see if solution is there
                    result += solutions[i] + " FOUND\n";
                    break; // No need to check further for this solution
                }
            }
        }
        return result.trim(); 
    }
    public static String up(String[][] arr, String[] solutions) {
        String result = ""; // Store the results for all solutions

        for (int i = 0; i < solutions.length; i++) { // Cycle through the solutions
            for (int c = 0; c < arr[0].length; c++) { // Cycle through each column
                String s = ""; // Build string of the column
                for (int r = arr.length - 1; r >= 0; r--) {
                    s += arr[r][c];
                }
                if (s.contains(solutions[i])) { // Check if solution is found
                    result += solutions[i] + " FOUND\n";
                    break; // No need to check further for this solution
                }
            }
        }
        return result.trim(); // Return the final result
    }
    public static String diagnol(String[][] arr, String[] solutions) {
        String result = ""; // Stores the results for all solutions 
    
        for (int i = 0; i < solutions.length; i++) { // Cycle through the solutions
            String word = solutions[i];
            boolean found = false; // Flag to track if word is found
    
            for (int r = 0; r < arr.length; r++) { 
                for (int c = 0; c < arr[0].length; c++) { 
                    String s1 = "", s2 = "", s3 = "", s4 = ""; // Strings for four diagonal directions
    
                    // Build diagonal strings in four directions
                    for (int k = 0; k < word.length(); k++) {
                        if (r + k < arr.length && c + k < arr[0].length) 
                            s1 += arr[r + k][c + k]; // ↘ Bottom-right
    
                        if (r + k < arr.length && c - k >= 0) 
                            s2 += arr[r + k][c - k]; // ↙ Bottom-left
    
                        if (r - k >= 0 && c + k < arr[0].length) 
                            s3 += arr[r - k][c + k]; // ↗ Top-right
    
                        if (r - k >= 0 && c - k >= 0) 
                            s4 += arr[r - k][c - k]; // ↖ Top-left
                    }
    
                    // Check if any diagonal contains the word
                    if (s1.contains(word) || s2.contains(word) || s3.contains(word) || s4.contains(word)) {
                        result += word + " FOUND\n";
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
    
            if (!found) {
                result += word + " NOT FOUND\n";
            }
        }
        
        return result.trim();
    }
    
}