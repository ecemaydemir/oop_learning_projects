package ecemaydemir;

import java.util.*;


public class FoodDeliveryPlatform {
	
	private HashMap<String, Sellable> products; // key:id -> value:ürün

	public FoodDeliveryPlatform() {
		this.products = new HashMap<>();
	}
	
	public void addProduct(Sellable product) {
		products.put(product.getId(), product);
	}
	
	public Sellable getProduct(String id) {
		Sellable s = products.get(id);
		return s;
	}
	
	public void listProducts() {
		for (Sellable s : products.values()) {
			System.out.println(s);
		}
	}
	
	public void searchByPriceRange(double min, double max) {
		for (Sellable s : products.values()) {
			if (s.getPrice() > min && s.getPrice() <= max) {
				System.out.println(s);
			}
		}
	}
	

}
