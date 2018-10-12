import java.util.ArrayList;

public class Squares {
	public static void main(String[] args) {
		
		int[] squares = new int[10];
		
		for (int i = 0; i < squares.length; i++) {
			squares[i] = i*i;
			}
		
		for (int j = 0; j < squares.length; j++) {
			System.out.println(j + ": " + squares[j]);
		}
	}
}



