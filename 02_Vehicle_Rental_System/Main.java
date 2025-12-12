package eaa;

public class Main {

	public static void main(String[] args) {
		
		 // Initialize the fleet with a capacity of 4 vehicles
        Filo filo = new Filo(4); 

        // Create vehicles using helper methods and add them to the fleet array
        filo.addVehicle(filo.createCar("Toyota", "Corolla", 2020, 4, 470)); // ID: CAR-TOY-2020-1000
        filo.addVehicle(filo.createCar("BMW", "320i", 2022, 4, 480));       // ID: CAR-BMW-2022-1001
        filo.addVehicle(filo.createMotorcycle("Honda", "CBR", 2019, 600, false)); // ID: MOTO-HO-600-1002
        filo.addVehicle(filo.createMotorcycle("Yamaha", "MT-07", 2021, 689, false)); // ID: MOTO-YA-689-1003

        filo.printAllVehicles();
        
        System.out.println();

        // All available vehicles:
        System.out.println("All available vehicles:");
        filo.printAvailable();
        System.out.println();
        

        // Available CARs only:
        System.out.println("Available CARs only:");
        filo.printAvailableByType("Car");
        System.out.println();

        
        // Rental test
        String idToRent = "CAR-BMW-2022-1001"; // Let's rent the second vehicle
        
        System.out.println("Attempting to rent: " + idToRent);
        filo.rentByID(idToRent);

        System.out.println("\nAvailable CARs after rental:");
        filo.printAvailableByType("Car");

        // Return test
        System.out.println("\nAttempting to return: " + idToRent);
        filo.returnByID(idToRent);

        System.out.println("\nAvailable CARs after return:");
        filo.printAvailableByType("Car");
        System.out.println();
        
        // Array capacity test
        filo.addVehicle(filo.createCar("Mercedes", "C200", 2023, 4, 500)); // Expecting 'capacity full' warning
 
	}

}