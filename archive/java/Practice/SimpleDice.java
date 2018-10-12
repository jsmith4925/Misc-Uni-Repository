import java.util.Scanner;

public class SimpleDice
{
	public static void main(String[] args)
	{
		final int SIDES = 6;
		int[] counters = new int[SIDES+1];
		
		System.out.println("Type value, non-integer to quit: ");
		Scanner in = new Scanner(System.in);
		
		//read in next values
		while (in.hasNextInt()) {
			int value = in.nextInt();
			
			//incriment the counter for the input value
			if (1 <= value && value <= SIDES) {
				counters[value]++;
				System.out.println("Count of " + value + " is " + counters[value]);
			}else {
				System.out.println(value + "is not a valid input.");
			}
		}
		
		//Print out the counts of the entered values 
		for (int j = 1; j < counters.length; j++) {
			System.out.println(j + ": " + counters[j]);
		}
	}
}