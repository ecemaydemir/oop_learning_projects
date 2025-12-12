package eaa;

public class Motorcycle extends Vehicle {

	private int engineCC;
	private boolean hasSidecar;
	
	public Motorcycle(String brand, String model, int year, int engineCC, boolean hasSidecar, int serial) {
		super(brand, model, year);
		this.engineCC = engineCC;
		this.hasSidecar = hasSidecar;
		this.uniqueID = generateUniqueIDBody(serial);
	}
	
	@Override
	public String generateUniqueIDBody(int serial) {
		return "MOTO-" + this.brand.substring(0, 2).toUpperCase() + "-" + this.engineCC + "-" + serial;
	}
	
	@Override
	public String getTypeName() {
		return "Motorcycle";
	}
	
	public int getEngineCC() {
		return engineCC;
	}
	
	public boolean hasSidecar() {
		return hasSidecar;
	}
 
	
}


