import java.util.Scanner;

class InputInteger {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int input;
				
		System.out.print("Enter an integer: ");
		while(!in.hasNextInt()){
			System.out.println("Try again.");
			in.next(); //'Throw away' wrong input
		}
		input = in.nextInt(); //actually read the integer
		System.out.println("Thank you. You typed: " +
			input);
		
		String input2;
		do {
			System.out.print("Enter either yes or no.");
			input2 = in.nextLine();
		} while (!input2.equalsIgnoreCase("yes") & !input2.equalsIgnoreCase("no"));

	}
}
