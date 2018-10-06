package smallapps1;

import java.util.*;
import static smallapps1.VolumeCalc.*;
import static smallapps1.printer.*;

public class SmallApps1 {
    
    
    public static void main(String[] args) {       
        String name;
        String[] badNames = {"Alex", "Dave", "Jacob"};
        

        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name?\n");
        
        name = scanner.nextLine();      
        
                if (contains(badNames, name)){            
            shitOnUser(name);
        }else{            
            printUser(name);
        }
        
        calculateVolume(5, 5, 5); 
        
        System.out.print("number between 1&7: ");
        int dayOfWeek = scanner.nextInt();
        System.out.print(printDayOfWeek(dayOfWeek) + "\n");
        
    }
    
    public static boolean contains(String[] arr, String item){
        for (String n : arr) {
            if (item.equals(n)) {
                return true;
            }
        }
        return false;
    }
    
}
