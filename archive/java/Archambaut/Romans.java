import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Romans {
	public static void main(String[] args) {
		
		String romanNumeral;
				
		Scanner in = new Scanner(System.in);
		//ask for input
		System.out.print("Enter a Roman Numeral: ");
		romanNumeral = in.next();
		System.out.print("The value of " + romanNumeral + " is " + calculateRomanNumeral(romanNumeral));
			
		}	
	
	
	//Method to convert single Roman Numeral to Int
	public static int romanNumeralToInt(String letterS){
		String[] romanNumerals ={"I", "V", "X", "L", "C", "D", "M"};
		int[] numberValues = {1, 5, 10, 50, 100, 500, 1000};
		int returnValue = 0;
		
		for (int i = 0; i < romanNumerals.length; i++) {
			if (romanNumerals[i].equals(letterS)) {
				returnValue = numberValues[i];
			}
			
		}
		
		return returnValue;	
	}
	public static int calculateRomanNumeral(String romanNumeral){
		int total = 0;			
		for (int i = 0; i < romanNumeral.length(); i++) {
			
			char letterC = romanNumeral.charAt(i);
			String letterS = Character.toString(letterC);
			
			total = total + romanNumeralToInt(letterS);
			System.out.println(total);
		}
	
	
		return total;	
	}
}	
