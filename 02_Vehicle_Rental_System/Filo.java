package eaa;

public class Filo {

	private final Vehicle[] vehicles;
	private int vehicleCount;
	private int serialCounter;
	
	public Filo(int capacity) {
		this.vehicleCount = 0;
		this.serialCounter = 1000;
		this.vehicles = new Vehicle[capacity];
	}
	
	public void addVehicle(Vehicle v) {
		boolean success = false;
		int i = 0;
		while (i < vehicles.length && !success) {
			if (vehicles[i] == null) {
				vehicles[i] = v;
				success = true;
				this.vehicleCount++;
				this.serialCounter++;
			}
			i++;
		}
		if (success == false)
			System.out.println("WARNING: Fleet capacity full! Could not add vehicle: " + v.getUniqueID());
	}
	
	public Car createCar(String brand, String model, int year, int doors, double trunkLiters) {
		int serial = serialCounter;
		Car c = new Car(brand, model, year, doors, trunkLiters, serial);
		return c;
	}
	
	public Motorcycle createMotorcycle(String brand, String model, int year, int engineCC, boolean hasSidecar) {
		int serial = serialCounter;
		Motorcycle m = new Motorcycle(brand, model, year, engineCC, hasSidecar, serial);
		return m;
	}
	
	public void printAllVehicles() {
		System.out.println("=== FLEET (All) ===");
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				System.out.println(vehicles[i]); // toString() zaten çağırılacak
			}
		}
	}
	
	public void printAvailable() {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null && vehicles[i].isAvailable()) {
				System.out.println(vehicles[i]);
			}
		}
	}
	
	public void printAvailableByType(String typeName) {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				Vehicle v = vehicles[i];
				if (v.isAvailable() && v.getTypeName().equalsIgnoreCase(typeName))
					System.out.println(v);
			}
		}
	}
	
	public Vehicle findByID(String ID) {
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				Vehicle v = vehicles[i];
				if (v.getUniqueID().equalsIgnoreCase(ID)) {
					return v;
				}
			}
		}
		return null;
	} 
	
	public boolean rentByID(String ID) {
		boolean success = false;
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				Vehicle v = vehicles[i];
				if (v.isAvailable() && v.getUniqueID().equalsIgnoreCase(ID)) {
					v.rent();
					success = true;
					System.out.println(ID + " rented.");
				}
			}
		}
		return success;
	}
	
	public boolean returnByID(String ID) {
		boolean success = false;
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] != null) {
				Vehicle v = vehicles[i];
				if (!v.isAvailable() && v.getUniqueID().equalsIgnoreCase(ID)) {
					v.giveBack();
					success = true;
					System.out.println(ID + " returned.");
				}
			}
		}
		return success;
	}

}