
	class Fruit {
	
		public String name;
		public String colour;

		
		public void setGeoVals(int area, int population){
			setArea(area);
			if (!setPopulation(population) || !setArea(area)) {
				System.out.println("Error");
			}
			setDensity();
		}
		
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
		
		public void setDensity() {
			density = population/area;
		}
	}
		
	public class TestFruit{	
	
		public static void main(String[] args){
			Country[] countries = new Country[2];
			countries[0] = new Country();
			countries[0].name = "Wales";
			countries[0].setArea(20761);
			if (!countries[0].setPopulation(3063000)){
				System.out.println("population error");
			};
			countries[0].setDensity();
			
			countries[1] = new Country();
			countries[1].name = "Greece";
			countries[1].setGeoVals(131957, 11030000);
			countries[1].area = -500;
			
			for(int i = 0; i < countries.length; i++){
				System.out.println(countries[i].name);
				System.out.println(countries[i].area);
				System.out.println("Density " + countries[i].density);
			}
		}
	}	
	
