import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.Scanner.*;

/** This is about <code>Classname</code>
 *
 *
 */

public class Romans {
	public static void main(String[] args) {
		
		String romanNumeral;
				
		Scanner in = new Scanner(System.in);
		//ask for input
		System.out.print("Enter a Roman Numeral: ");
		romanNumeral = in.next();
		System.out.print("The value of " + romanNumeral + "is" + romanNumeralToInt(romanNumeral));
			
		}
	
	//@Override
	//Method to convert single Roman Numeral to Int
	public static int romanNumeralToInt(String romanNumeral){
		String[] romanNumerals = {"I", "V", "X", "L", "C", "D", "M"};
		int[] numberValues = {1, 5, 10, 50, 100, 500, 1000};
		int returnValue = 0;
		for (int i = 0; i< romanNumerals.length; i++) {
			if (romanNumerals[i]==romanNumeral) {
				returnValue = numberValues[i];
			}
			
		}
		
		return returnValue;	
	}
}	

