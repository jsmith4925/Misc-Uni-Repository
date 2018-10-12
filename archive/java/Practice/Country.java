
	class Country {
	
		public String name;
		public int area;
		public int population;
		public int density;
	}
		
public class TestCountry{	
	
	public static void main(String[] args){
			Country[] countries = new Country[2];
			countries[0] = new Country();
			countries[0].name = "Wales";
			countries[0].area = 20761;
			countries[0].population = 3063000;
			countries[0].density = 3063000/20761;
			
			countries[1] = new Country();
			countries[1].name = "Greece";
			countries[1].area = 131957;
			countries[1].population = 11030000;
			countries[1].density = countries.population/countries[1].area;
			
			for(int i = 0; i < countries.length; i++){
				System.out.println(countries[i].name);
				System.out.println(countries[i].area);
				System.out.println("Density " + countries[i].density);
			}
	}
}	
	
