import java.util.Scanner;

public class Car {
	private int productionYear;
	private int engineCapacity;
	
	Car() {
		this.productionYear = 0;
		this.engineCapacity = 0;
	}
	
	Car(int productionYear, int engineCapacity) {
		this.productionYear = productionYear;
		this.engineCapacity = engineCapacity;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	
	public void display() {
		System.out.print("  -----------------------");
		System.out.println("\n  Information about car:");
		System.out.println("    Production year: " + this.productionYear);
		System.out.println("    Engine capacity: " + this.engineCapacity);
		System.out.println("  ---------------------");
	}
	
	@Override
	public String toString() {
		return "" + productionYear;
	}

	public static void order(Car cars[]) {
		Car carsCopy[] = cars;
		
		int size = carsCopy.length;
		
	    for (int i = 0; i < size - 1; i++)
	      for (int j = 0; j < size - i - 1; j++)
	        if (Integer.parseInt(carsCopy[j].toString()) < Integer.parseInt(carsCopy[j + 1].toString())) {
	          Car temp = carsCopy[j];
	          cars[j] = cars[j + 1];
	          cars[j + 1] = temp;
	        }
	    
	    for (Car car : carsCopy) {
	    	car.display();
	    }
	}
	
	public static void showCar(int year, Car cars[]) {
		for (Car car : cars) {
			if(car.getProductionYear() == year) {
				car.display();
			}
		}
	}
	
	public static void main(String[] args) {
		Car cars[] = new Car[4];
		int productionYear;
		
		for (int i = 0; i < 4; i++) {
			cars[i] = new Car(1990 + i, 86 + i);
		}
		
		System.out.println("\nCars: ");
		
		for (Car car : cars) {
			car.display();
		}
		
		System.out.println("\nEnter the production year of car information about you want to see: ");
		
		Scanner in = new Scanner(System.in);
		productionYear = in.nextInt();
		in.close();

		showCar(productionYear, cars);
		
		System.out.println("\nDisplay cars ordered by decreasing of production year: ");
		
		order(cars);
		
	}
}
