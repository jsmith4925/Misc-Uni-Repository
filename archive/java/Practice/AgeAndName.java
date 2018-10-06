import java.util.Scanner;

public class AgeAndName{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		String[] names = new String[10];
		int[] age = new int[10];
		int newAge;
		String newName = "";
		
	
		
		for(int i = 0; i < names.length; i++){
			
				System.out.print("Enter an Name: ");
			
				while(in.hasNextInt()){
					System.out.println("Try again.");
					in.next(); //'Throw away' wrong input
				}
				while(!(in.nextLine().equals("done"))){
					
					newName = in.next();
				
					System.out.print("Now enter age of " + newName +": ");
				
					while(!in.hasNextInt()){
						System.out.println("Try again.");
						in.next(); //'Throw away' wrong input
					}
					newAge = in.nextInt(); //actually read the integer
					
								
				names[i] = newName; //Store new data into Arrays
				age[i] = newAge;
				}	
			
		}		
	
	
		for (int j = 0; j < names.length; j++) {
			System.out.println(names[j] + ":\t " + age[j]);
		}	
			
		
	}
}