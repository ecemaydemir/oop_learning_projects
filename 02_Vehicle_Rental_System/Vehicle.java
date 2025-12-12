package eaa;

public abstract class Vehicle {

	protected String brand;  
	protected String model;
	protected int year;
	protected String uniqueID;
	protected boolean rented;
	
	
	public Vehicle(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.rented = false;
	}
	
	public abstract String generateUniqueIDBody(int serial);
	
	public String getUniqueID() {
		return uniqueID;
	}
	
	public boolean isAvailable() {
		return !rented;
	}
	
	public void rent() {
		if (rented == false)
			rented = true;
		else 
			System.out.println("Vehicle is not available");
	}
	
	public void giveBack() {
		if (rented)
			rented = false;
		else 
			System.out.println("Vehicle is not currently rented.");
	}
	
	public abstract String getTypeName();
	
	public String toString() {
		return getTypeName() + " => " +this.brand + " " + this.model 
				+ " (" + this.year + ") | ID: " + getUniqueID() 
				+ " | Status: " + (isAvailable() ? "Available" : "Not Available");
	}

}