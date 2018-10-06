/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallapps1;

public class printer {
    
    public static void printUser(String user){
        
        System.out.print("Hello ");
        System.out.print(user);
        System.out.print("!\n");
        
    }
    
    public static void shitOnUser(String user){
               
        System.out.println("Oh fuck off, "+ user + ", we all hate you..");
    }
    
    public static String printDayOfWeek(int dayOfWeek){
        
        String day = "";
        
        switch(dayOfWeek){
            case 1: day = "Monday";
                    break;
            case 2: day = "Tuesday";
                    break;
            case 3: day = "Wednesday";
                    break;
            case 4: day = "Thursday";
                    break;
            case 5: day = "Friday";
                    break;
            case 6: day = "Saturday";
                    break;
            case 7: day = "Sunday";
                    break;            
        }
        return day;
        
    }
    
}
