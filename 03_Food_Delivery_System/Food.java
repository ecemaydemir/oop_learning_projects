package ecemaydemir;

public class Food implements Sellable {

	private String id;
	private String name;
	private double price;
	private String restaurant;
	
	public Food(String id, String name, double price, String restaurant) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
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
		return "Food [id=" + getId() + ", name=" + getName() 
				+ ", price=" + getPrice() + ", restaurant=" + this.restaurant + "]";
 	}
}
