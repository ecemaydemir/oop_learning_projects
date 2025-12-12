package eaa;

public class Car extends Vehicle {

	private int doors;
	private double trunkLiters;
	
	public Car(String brand, String model, int year, int doors, double trunkLiters, int serial) {
		super(brand, model, year);
		this.doors = doors;
		this.trunkLiters = trunkLiters;
		this.uniqueID = generateUniqueIDBody(serial);
	}
	
	@Override
	public String generateUniqueIDBody(int serial) {
		return "CAR-" + this.brand.substring(0, 3).toUpperCase() + "-" + this.year + "-" + serial;
	}
	
	@Override
	public String getTypeName() {
		return "Car";
	}
	
	public int getDoors() {
		return doors;
	}
	
	public double getTrunkLiters() {
		return trunkLiters;
	}
}
