import java.util.Scanner;

public class SillyDice
{ 
   public static void main(String[] args)
   {   
      int side1 = 0;
      int side2 = 0;
      int side3 = 0;
      int side4 = 0;
      int side5 = 0;
      int side6 = 0;
   
      System.out.println("Type values, non-integer to quit:");
      Scanner in = new Scanner(System.in);
      while (in.hasNextInt()) {  
         int value = in.nextInt();

         if (value == 1) {
         	side1++;
         } else if (value == 2) {
         	side2++;
         } else if (value == 3) {
         	side3++;
         } else if (value == 4) {
         	side4++;
         } else if (value == 5) {
         	side5++;
         } else if (value == 6) {
         	side6++;
         } else {
         	System.out.println("Not a valid value.");
         }
      }
      
      System.out.println("1: " + side1);
      System.out.println("2: " + side2);
      System.out.println("3: " + side3);
      System.out.println("4: " + side4);
      System.out.println("5: " + side5);
      System.out.println("6: " + side6);  
   }
}
