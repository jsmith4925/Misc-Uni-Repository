import java.util.ArrayList;

	class Country {
	
		private String name;
		private int area;
		private int population;
		//private int density;
		
		public Country(String name, int area, int population){
			setName(name);
			setGeoVals(area, population);
		}
		
		public Country(){
		}
		
		public Country(String name){
			setName(name)
		}
		
		public String getName(){
			return name;
		}
		
		public int getArea(){
			return area;
		}
		
		public int getDensity(){
			return population/area;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public void setGeoVals(int area, int population){
			setArea(area);
			if (!setPopulation(population) || !setArea(area)) {
				System.out.println("Error");
			}
			//setDensity();
		}
		
		/*private void setDensity() {
			density = population/area;
		}*/
		
		public boolean setArea(int area){
			if (area > 0){
				this.area = area;
				return true;
			} else {
				return false;
			}
		}
		
		public boolean setPopulation(int population){
			if (population > 0){
				this.population = population;
				return true;
			} else {
				return false;
			}
		}
	}	
	public class TestCountry{	
	
		public static void main(String[] args){
			ArrayList<Country> countries = new ArrayList<>();
			
			/*countries[0] = new Country();
			countries[0].setName("Wales");*/
			Country wales = new Country("Wales",20761,3063000);
			
			Country greece = new Country("Greece");
			greece.setGeoVals(131957,11030000);
			
			countries.add(wales);
			countries.add(greece);
						
			for(Country country : countries){
				System.out.println(country.getName());
				System.out.println(country.getArea());
				System.out.println("Density " + country.getDensity());
			}
		}
	}	
	
