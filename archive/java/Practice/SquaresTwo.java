import java.util.ArrayList;

public class SquaresTwo {
	public static void main(String[] args) {
		
		ArrayList<Integer> squares = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			squares.add(i);
		}
		
		for (int i = 0; i < squares.size(); i++) {
			squares.set(i, squares.get(i)*squares.get(i));
			}
						
		for (int j = 0; j < squares.size(); j++) {
			System.out.println(j + ": " + squares.get(j));
		}
	}
}



