package ecemaydemir;

public class Drink implements Sellable {

	private String id;
	private String name;
	private double price;
	private String size;
	
	public Drink(String id, String name, double price, String size) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.size = size;
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Drink [id=" + getId() + ", name=" + getName() 
				+ ", price=" + getPrice() + ", size=" + this.size + "]";
 	}
}
