package ea;

public class Company {
	
	private String companyName;
	private Tour[] tours;
	private Ticket[] tickets;
	private Staff[] staff;

	public Company(String companyName, int tourCount, int ticketCount, int staffCount) {
		this.companyName = companyName;
		this.tours = new Tour[tourCount];
		this.tickets = new Ticket[ticketCount];
		this.staff = new Staff[staffCount];
	}
	
	public void addTour(Tour tour) {
		boolean success = false;
		int i = 0;
		while (i < tours.length && !success) {    // success = false → !success = true → döngü başlar.
			if (tours[i] == null) {
				tours[i] = tour;
				success = true;
			}
			i++;
		}
	}
	
	public void addTicket(Ticket ticket) {
		boolean success = false;
		int i = 0;
		while (i < tickets.length && !success) {    // success = false → !success = true → döngü başlar.
			if (tickets[i] == null) {
				tickets[i] = ticket;
				success = true;
			}
			i++;
		}
	}
	
	public void listTours() {
		System.out.println("---- Available Tours ----");
		for (int i = 0; i < tours.length; i++) {
			if (tours[i] != null) {
				System.out.println("Tour: " + tours[i].getTourName()
						+ " | City: " + tours[i].getCity()
						+ " | Price: " + tours[i].getPrice());
			}
		}
	}
	
	public void listTickets() {
		System.out.println("---- Available Tickets ----");
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] != null) {
				System.out.println("From: " + tickets[i].getDeparture()
						+ " | To: " + tickets[i].getArrival()
						+ " | Airline: " + tickets[i].getAirlineCompany()
						+ " | Price: " + tickets[i].getPrice());
			}
		}
	}
	
	public void searchTour(String tourCity) {  // Girilen şehirde düzenlenen turları ekrana yazdırır
		System.out.println("Tours found in " + tourCity + ":");
		for (int i = 0; i < tours.length; i++) {
			if (tours[i] != null) {
				Tour t = tours[i];
				if (t.getCity().equalsIgnoreCase(tourCity)) {
					System.out.println("Tour name: " + t.getTourName()
								+ " | Price: " + t.getPrice());
				}
			}
		}
	}
	
	public void searchCheapestTicket(String cityName) {  // Verilen şehre (varış noktasına) ait en ucuz bileti yazdırır
		Ticket cheapestTicket = null;
		double minPrice = 0.0;
		int i;
		for (i = 0; i < tickets.length; i++) {
			if (tickets[i] != null) {
				Ticket t = tickets[i];
				if (t.getArrival().equalsIgnoreCase(cityName)) {
					double currentPrice = t.getPrice();
					if (cheapestTicket == null || currentPrice < minPrice) {
						minPrice = currentPrice;
						cheapestTicket = t;
					}
				}
			}
		}
		System.out.println("Cheapest Ticket to " + cheapestTicket.getArrival() + " is " + minPrice + "₺ from " + cheapestTicket.getAirlineCompany());
	}
	
	public void showCitiesWithToursAndFlights() {   // Hem tur hem uçuş (bilet) bulunan şehirleri listeler
		
		System.out.println("Cities that have both a tour and a flight avaliable:");
		
		boolean success = false;
		String cityName = null;
		
		for (int i = 0; i < tours.length; i++) {
			if (tours[i] != null) {
				cityName = tours[i].getCity();
				
				boolean seen = false;
	            int j = 0;
	            while (j < i) {
	                if (tours[j] != null && cityName.equalsIgnoreCase(tours[j].getCity())) {
	                    seen = true;
	                    break;
	                }
	                j++;
	            }
	            if (seen) {
	                continue; // daha önce yazdırıldıysa geç
	            }
	            
				int k = 0;
				while (k < tickets.length) {
					if (tickets[k] != null) {
						if (cityName.equalsIgnoreCase(tickets[k].getArrival())) {
							success = true;
							System.out.println("- " + cityName);
							break;
						}	
					}
					k++;
				}
			}
		}
	}
	
	public void addStaff(Staff s) {
		boolean success = false;
		int i = 0;
		while (i < staff.length && !success) {    // success = false → !success = true → döngü başlar.
			if (staff[i] == null) {
				staff[i] = s;
				success = true;
			}
			i++;
		}
	}
	
	public double averageStaffSalary() {
		double count = 0;
		double total = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i] != null) {
				count++;
				total += staff[i].getSalary();
			}
		}
		return total/count;
	}
	
	public int findOldestStaffAge() {
		int maxAge = 0;
		for (int i = 0; i < staff.length; i++) {
			if (staff[i] != null) {
				int currentAge = staff[i].getAge();
				if (currentAge > maxAge)
					maxAge = currentAge;
			}
		}
		return maxAge;
	}
	
		
}

