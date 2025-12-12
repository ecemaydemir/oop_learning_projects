package ea;

public class Ticket {
	
	private String departure; // kalkış
	private String arrival;   // varış
	private String airlineCompany;
	private double price;

	public Ticket(String departure, String arrival, String airlineCompany, double price) {
		this.departure = departure;
		this.arrival = arrival;
		this.airlineCompany = airlineCompany;
		this.price = price;
	}

	public String getDeparture() {
		return departure;
	}

	public String getArrival() {
		return arrival;
	}

	public String getAirlineCompany() {
		return airlineCompany;
	}

	public double getPrice() {
		return price;
	}
	
	

}
