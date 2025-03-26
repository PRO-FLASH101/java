import java.util.*; 

public class prob72018 {
    //variables
    public static ArrayList<String> temp; 

    //helper methods cus i don't know recursion yet 
    public static Object similar(ArrayList<String> arr, int index, int trial){ 
        temp.clear();
        
        temp.add(arr.get(0)); 
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(trial).charAt(index) == arr.get(i).charAt(index)){
                temp.add(arr.get(i));
            }
        }

        if(temp.size() == 1){
            return true; //for not using the not operator 
        }
        else{
            return temp; 
        }
    }

    public static Object notsimilar(ArrayList<String> arr, int index, int trial){ 
        temp.clear(); 
        
        temp.add(arr.get(trial)); 
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(trial).charAt(index) != arr.get(i).charAt(index)){
                temp.add(arr.get(i));
            }
        }

        if(temp.size() == 1){
            return true; //for not using the not operator 
        }
        else{
            return temp; 
        }
    }

    //main method 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        //gets the number of inputs 
        int times = scan.nextInt();

        //to get the newline scan thingy
        scan.nextLine();

        //creates arraylist of inputs (maybe change to array to boost efficeny)
        ArrayList<String> arr = new ArrayList<String>();

        //uses for loop to add to list
        for(int i = 0; i < times; i++){
            arr.add(scan.nextLine());
        }

        //ends scanner to save efficeny 
        scan.close();

        //if similar is true try diff
        //if notsimilar is true try similar 
        for(int i = 0; i < arr.size(); i++){ //keeps track of wat word 
            //if similar is true try diff
            for(int j = 0; j < temp.size(); j++){ //cycles through 2 diff possiblities 

            }
        }

        //debugger line 
        System.out.println(arr); 



    }
}
