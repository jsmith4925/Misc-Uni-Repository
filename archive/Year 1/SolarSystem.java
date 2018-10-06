import java.util.Random;
import java.util.Scanner;

	class Planet {
		public String systemName;
		public String name;
		public double mass;
		public double distance;
		public double orbit;
		
		public void calculatePeriod(double mass, double distance){
			setOrbit();
		}
		public void setOrbit() {
			orbit = Math.sqrt(distance*distance*distance);
			orbit = Math.round(orbit*1000)/1000.0;
		}

	}
	

	public class SolarSystemTEST{
	
		public static void main(String[] args){
			
			Planet[] planets = new Planet[9];
			
			String systemName = getInput("Enter the name of the Solar System: ");
			
			System.out.print("Now enter planet names - type 'done' to finish\n");
			
			
			String name = getInput("What's your planets name?: ");
			
			
				for(int i=0; !name.equals("done"); i++){
					int planetNumber = 0;
					planets[planetNumber] = new Planet();
					planets[planetNumber].name = name;
					planets[planetNumber].mass = generateMass();
					planets[planetNumber].distance = generateDistance();
					planets[planetNumber].calculatePeriod(planets[0].mass, planets[0].distance);
					System.out.print(planets[planetNumber].name);
					System.out.print(" has a mass of ");
					System.out.print(planets[planetNumber].mass);
					System.out.print(" and a the distance from the sun is ");
					System.out.print(planets[planetNumber].distance);
					System.out.print("AU. This makes the orbital period ");
					System.out.print(planets[planetNumber].orbit);
					System.out.print("\n");
					planetNumber = planetNumber++;
					name = getInput("What's your planets name?: ");				
				}	
			

			System.out.print("Name");
			System.out.print("\t\t");
			System.out.print("Mass");
			System.out.print("\t\t");
			System.out.print("Distance");
			System.out.print("\t");
			System.out.print("Period (years)");
			System.out.print("\n");
			
			for(int j = 0; j < planets.length; j++){
				System.out.print(planets[j].name);
				System.out.print("\t\t");
				System.out.print(planets[j].mass);
				System.out.print("\t\t");
				System.out.print(planets[j].distance);
				System.out.print("\t\t");
				System.out.print(planets[j].orbit);
				System.out.print("\n");
			}
		}
		public static String getInput(String message) {
			Scanner in = new Scanner(System.in);
			System.out.print(message);
			String value = in.next();
			return value;
		}
		public static double generateMass(){
			double value = ((callRandom(16000)) / 1000);
			value = Math.round(value*1000)/1000.0;
			return value;
		}
		public static double generateDistance(){
			double value = ((callRandom(5000)) / 1000);
			value = Math.round(value*1000)/1000.0;
			return value;
		}	
		public static double callRandom(int limit){
			Random rnd = new Random();
			double value = rnd.nextDouble()*limit;
			value = Math.round(value*1000)/1000.0;
			return value;
		}
	}
