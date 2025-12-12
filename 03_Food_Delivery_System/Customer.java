package ecemaydemir;

import java.util.*;

public class Customer {

	private String id; 
	private String name;
	private ArrayList<Sellable> cart;
	
	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
		this.cart = new ArrayList<>();
	}
	
	public void addToCart(Sellable item) throws ItemAlreadyinCartException {
		for (Sellable s : cart) {
			if (item.getId().equalsIgnoreCase(s.getId())) {
				throw new ItemAlreadyinCartException("ERROR: This item is already in your cart: " + s.getName());
			}
		}
		cart.add(item);
		System.out.println("Added to cart: " + item.getName());
	}
	
	
	public void removeFromCart(String itemId) {
		for (Sellable s : cart) {
			if (s.getId().equalsIgnoreCase(itemId)) {
				cart.remove(s);
				System.out.println("Removed from cart: " + s.getName());
			}
		}
	}
	
	public void showCartDetails() {
		if (!cart.isEmpty()) {
			for (Sellable s : cart) {
				System.out.println(s.getName() + " : " + s.getPrice() + "₺");
			}
		}
		else {
			System.out.println("Cart is empty.");
			
		}
	}
	
	public void Payment() {
		double total = 0;
		for (Sellable s : cart) {
			total += s.getPrice();
			
		}
		System.out.println("Total payment: " + total + "₺"); 
		cart.clear();
	}
	
	
	

}
