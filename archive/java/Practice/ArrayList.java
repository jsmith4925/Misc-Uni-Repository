import java.util.ArrayList;
import java.util.Arrays;

public class ArrayList{
	public static void main(String []args){
		
		Integer[] numbers = {1, 7, -3, 14, 19, 0, 2, -8, 6, 11, 3, 5};
		ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(numbers));
		int smallest = 0;
		int largest = 0;
		
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0){
			smallest = numbers.get(0);
			}
			if (numbers.get(i) < smallest){
				smallest = numbers.get(i);
			}
		}
		System.out.println("The Smallest Numbers is: " + smallest);
		
		for(int i = 0; i < numbers.size(); i++) {
			if (i == 0){
			largest = numbers.get(0);
			}
			if (numbers.get(i) > largest){
				largest = numbers.get(i);
			}
		}
		System.out.println("The largest Number is: " + largest);
	}	
}