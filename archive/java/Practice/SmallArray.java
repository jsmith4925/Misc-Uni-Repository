import java.util.ArrayList;

public class SmallArray{
	public static void main(String []args){
		
		int[] numbers = {1, 7, -3, 14, 19, 0, 2, -8, 6, 11, 3, 5};
		int smallest = 0;
		int largest = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			if (i == 0){
			smallest = numbers[0];
			}
			if (numbers[i] < smallest){
				smallest = numbers[i];
			}
		}
		System.out.println("The Smallest Numbers is: " + smallest);
		
		for(int i = 0; i < numbers.length; i++) {
			if (i == 0){
			largest = numbers[0];
			}
			if (numbers[i] > largest){
				largest = numbers[i];
			}
		}
		System.out.println("The largest Number is: " + largest);
	}	
}