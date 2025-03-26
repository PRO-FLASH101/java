import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    /* problem 7 helper
    public static void helper(ArrayList<String> matters){
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for(int i = 0; i < matters.size(); i++){
            switch(matters.get(i).substring(0, 1)){
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "C":
                    c++;
                    break;
                case "D":
                    d++;
                    break;
            }
        }
        //finds minimun
        int min; 

        if(a == 0){
            min = Math.min(b, Math.min(c,d));
        }
        else if (b == 0){
            min = Math.min(a, Math.min(c,d));
        }
        else if (c == 0){
            min = Math.min(b, Math.min(a,d));
        }
        else if(d == 0){
            min = Math.min(b, Math.min(c,a));
        }
        else{
            min = Math.min(b, Math.min(a , Math.min(c,d)));
        }
                
        if(min == a){
            for(int j = 0; j < matters.size(); j++){
                String word = matters.get(j);
                for(int i = 0; i < word.length(); i++){
                    if(word.substring(i, i + 1).equals("A")){
                        word = word.substring(0, i) + word.substring(i + 1);
                        matters.set(j, word);                            
                        break;
                    }
                }
            }
        }
        else if(min == b){
            for(int j = 0; j < matters.size(); j++){
                String word = matters.get(j);
                for(int i = 0; i < word.length(); i++){
                    if(word.substring(i, i + 1).equals("B")){
                        word = word.substring(0, i) + word.substring(i + 1);
                        matters.set(j, word);
                        break;
                    }
                }
            }
        }   
        else if(min == c){
            for(int j = 0; j < matters.size(); j++){
                String word = matters.get(j);
                for(int i = 0; i < word.length(); i++){
                    if(word.substring(i, i + 1).equals("C")){
                        word = word.substring(0, i) + word.substring(i + 1);
                        matters.set(j, word);
                        break;
                    }
                }
            }
        }
        else if(min == d){
            for(int j = 0; j < matters.size(); j++){
                String word = matters.get(j);
                for(int i = 0; i < word.length(); i++){
                    if(word.substring(i, i + 1).equals("D")){
                        word = word.substring(0, i) + word.substring(i + 1);
                        matters.set(j, word);
                        break;
                    }
                }
            }
        }
            
    }
*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //user inputed number for triples 
        int num = scan.nextInt();

        //possible combos 
        ArrayList<ArrayList<Integer>> possible = new ArrayList<>();        

        //Becuase ms.rahman said the header doesn't get confusing 
        int end = (int) Math.sqrt(num);

        // Adds possible combinations
        for (int i = 1; i <= end; i++) {
            ArrayList<Integer> inner = new ArrayList<>(); // Create a new inner list for each iteration
            if (Math.pow(i, 2) == num) {
                inner.add(i);
                inner.add(i);
                possible.add(inner); // Add the new inner list to possible
            } else if (num % i == 0) {
                inner.add(i);
                inner.add(num / i);
                possible.add(inner); // Add the new inner list to possible
            }
        }

        //debug line (DELETE LATER!!!!!!!)
        System.out.println(possible);

        // Temporary list to store new elements
        ArrayList<ArrayList<Integer>> newElements = new ArrayList<>();

        for (int i = 0; i < possible.size(); i++) {
            if (possible.get(i).get(0) == 1) { //fix this if statement 
                // Create a new list for the 1 x 1 situation
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(1);
                newList.add(1);
                newList.add(possible.get(i).get(1));
                newElements.add(newList); // Add to the temporary list
            } else { //fix this else statement 
                // If the first element is not 1, check if it can be divided by 3, 2, or 1
                if (possible.get(i).get(1) % 3 == 0) {
                    possible.get(i).add(possible.get(i).get(1) / 3);
                    possible.get(i).set(1, 3);
                } else if (possible.get(i).get(1) % 2 == 0) {
                    possible.get(i).add(possible.get(i).get(1) / 2);
                    possible.get(i).set(1, 2);
                } else if (possible.get(i).get(1) % 1 == 0) {
                    possible.get(i).add(possible.get(i).get(1));
                    possible.get(i).set(1, 1);
                }
            }
        }

        // Add all new elements to the `possible` list after the loop
        possible.addAll(newElements);
        
        // Sort each inner list in ascending order
        for (ArrayList<Integer> i : possible) {
            Collections.sort(i);
        }

        // Sort the outer list in descending order based on the first element of each inner list
        possible.sort((list1, list2) -> list2.get(0) - list1.get(0));

        // Output the answer
        System.out.println(num + " has " + possible.size() + " factor triples:");
        for (ArrayList<Integer> i : possible) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        /*problem 7 
        //ALL POSSIBLE SOLUTIONS
        String[] choices = {"ABCD", "ABDC", "ACBD", "ACDB", "ADBC", "ADCB", "BACD", "BADC", "BCAD", "BCDA", "BDAC", "BDCA", "CABD", "CADB", "CBAD", "CBDA", "CDAB", "CDBA", "DABC", "DACB", "DBAC", "DBCA", "DCAB", "DCBA"};

        //what the order of votes are
        int[] votes = new int[24];

        //gets the votes
        for(int i = 0; i < 24; i++){
            votes[i] = scan.nextInt();
        }

        //the list that matters
        ArrayList<String> matters = new ArrayList<String>();

        //adds the votes choices to the list
        for(int i = 0; i < 24; i++){
            if(votes[i] == 0){
                continue; 
            }
            else if(votes[i] != 0){
                for(int j = 0; j < votes[i]; j++){
                    matters.add(choices[i]);
                }
            }
        }

        //first round elimination  
        helper(matters);

        //second round of elimination  
        helper(matters); 

        //figures out which letter is highest 
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0; 

        for(int i = 0; i < matters.size(); i++){
            switch(matters.get(i).substring(0, 1)){
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "C":
                    c++;
                    break;
                case "D":
                    d++;
                    break; 
            }
        }

        //finds max
        int max = Math.max(a, Math.max(b, Math.max(c, d)));

        if(max == a){
            System.out.println("A\n" + a);
        }
        else if(max == b){
            System.out.println("B\n" + b);
        }   
        else if(max == c){
            System.out.println("C\n" + c);
        }
        else if(max == d){
            System.out.println("D\n" + d);
        }
    */

        /* SOLUTION FOR 5
        //gets the number of die 
        System.out.print("Enter number of die: ");
        int num = scan.nextInt();

        ArrayList<Integer> numsides = new ArrayList<Integer>();
        
        //add the sides to the array numsides 
        for(int i = 0; i < num; i++){
            System.out.print("Enter in die side: ");
            int s1 = scan.nextInt();
            numsides.add(s1);
        }
        //System.out.println(numsides);

        //gets the amount wanted 
        System.out.print("Enter wanted amount: ");
        int want = scan.nextInt();

        //total amount of ways
        int count = 0;

        //if 1 die there is only 1 possible answer if they input is not a jerk 
        if(num == 1){
            for(int i = 0; i < numsides.get(0); i++){
                if(i == want){
                    count++;
                }
            }
            System.out.println(count); 
        }
        //if the number of die is greater than the want there is no way even if everything is 1
        else if(numsides.size() > want){
            System.out.println(count); 
        }
        //for everything else 
        else{
            if(num == 2){
                for(int i = 0; i <= numsides.get(0); i++){
                    for(int j = i; j <= numsides.get(1); j++){
                        if(i + j == want){
                            count++;
                        }
                    }
                }
                System.out.println(count); 
            }
            else if(num == 3){
                for(int a = 0; a <= numsides.get(0); a++){
                    for(int b = 0; b <= numsides.get(1); b++){
                        for(int c = 0; c <= numsides.get(2); c++){
                            if(a + b + c == want){
                                count++; 
                            }
                        }
                    }
                }
                System.out.println(count); 
            }
            else if(num == 4){
                for(int a = 0; a <= numsides.get(0); a++){
                    for(int b = 0; b <= numsides.get(1); b++){
                        for(int c = 0; c <= numsides.get(2); c++){
                            for(int d = 0; d <= numsides.get(3); d++){
                                if(a + b + c + d == want){
                                    count++;
                                }
                            }
                        }
                    }
                }
                System.out.println(count); 
            }
            else if(num == 5){
                for(int a = 0; a <= numsides.get(0); a++){
                    for(int b = 0; b <= numsides.get(1); b++){
                        for(int c = 0; c <= numsides.get(2); c++){
                            for(int d = 0; d <= numsides.get(3); d++){
                                for(int e = 0; e <= numsides.get(4); e++){
                                    if(a + b + c + d + e == want){
                                        count++; 
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(count); 
            }
            else if(num == 6){
                for(int a = 0; a <= numsides.get(0); a++){
                    for(int b = 0; b <= numsides.get(1); b++){
                        for(int c = 0; c <= numsides.get(2); c++){
                            for(int d = 0; d <= numsides.get(3); d++){
                                for(int e = 0; e <= numsides.get(4); e++){
                                    for(int i = 0; i <= numsides.get(5); i++){
                                        if(a + b + c + d + e + i == want){
                                            count++; 
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(count); 
            }
        }
*/
        scan.close();


    }
}