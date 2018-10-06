import java.util.Scanner;

public class computeGCD { 
	public static void main(String[] args){
		int y;
		int x;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter X: ");
		x = in.nextInt();
		System.out.print("X = " + x + ". Enter Y: ");
		y = in.nextInt();
		System.out.print("The remainder of " + x + " divided by " + y + " is " + computeGCD(x,y));
		
		
	}
	
	public static int computeGCD(int x, int y) {
		int temp;
		while (y != 0) {
			temp = y;
			y = x%y;
			x = temp;
		}
		return x;
	}	
	
}