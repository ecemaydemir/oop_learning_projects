# oop_learning_projects
My OOP learning journey. Demonstrates OOP concepts through code examples and class design.

## Travel Agency System
**Folder:** `01_Travel_Agency_System`
* **Focus:** Association, Dependency, Aggregation relationships.
* **Description:** A system managing tours, tickets, and staff using separate classes.

### UML Class Diagram
```mermaid
classDiagram
    class Main {
        +main(String[] args)
    }

    class Company {
        -companyName : String 
        -tours : Tour[] 
        -tickets : Ticket[] 
        -staff : Staff[]
        +Company(String, tourCount: int, ticketCount: int, staffCount: int)
        +addTour(tour: Tour) void
        +addTicket(ticket: Ticket) void
        +listTours() void
        +listTickets() void
        +searchTour(tourCity: String) void
        +showCitiesWithToursAndFlightsAvailable() void
        +addStaff(staff: Staff) void
        +averageStaffSalary() double
        +findOldestStaffAge() int
    }

    class Tour {
        -tourName : String 
        -city : String
        -price : double
        +Tour(String, String, double)
        +getTourName() String
        +getCity() String
        +getPrice() double
    }

    class Ticket {
        -departure : String
        -arrival : String 
        -airlineCompany : String
        -price : double
        +Ticket(String, String, String, double)
        +getDeparture() String
        +getArrival() String
        +getAirlineCompany() String
        +getPrice() double
    }

    class Staff {
        -name : String 
        -age : int
        -salary : double
        +Staff(String, int, double)
        +getName() : String
        +getAge() : int
        +getSalary() : double
    }

    %% Relationships
    Company "1" o-- "*" Staff : Aggregation
    Main ..> Company : Dependency
    Company "1" --> "*" Tour : Association
    Company "1" --> "*" Ticket : Association
```

## Vehicle Rental System
**Folder:** `02_Vehicle_Rental_System`  
* **Focus:** Inheritance, Polymorphism, Abstraction, Encapsulation.
* **Description:** A simulation managing a fleet of cars and motorcycles using inheritance and polymorphism.


### UML Class Diagram
```mermaid
classDiagram
    class Filo {
        -vehicles : Vehicle[]
        -vehicleCount : int
        -serialCounter : int
        +Filo(int capacity)
        +addVehicle(Vehicle v) void
        +createCar(String brand, String model, int year, int doors, double trunkLiters) Car
        +createMotorcycle(String brand, String model, int year, int engineCC, boolean hasSidecar) Motorcycle
        +printAllVehicles() void
        +printAvailable() void
        +printAvailableByType(String typeName) void
        +findByID(String ID) Vehicle
        +rentByID(String ID) boolean
        +returnByID(String ID) boolean
    }

    class Vehicle {
        <<abstract>>
        #brand : String
        #model : String 
        #year : int
        #uniqueID : String 
        #rented : boolean 
        +Vehicle(String brand, String model, int year)
        +generateUniqueIDBody(int serial) String
        +getUniqueID() String
        +isAvailable() boolean
        +rent() void
        +giveBack() void
        +getTypeName() String
        +toString() String
    }

    class Car {
        -doors : int
        -trunkLiters : double
        +Car(String brand, String model, int year, int doors, double trunkLiters, int serial)
        +generateUniqueIDBody(int serial) String
        +getTypeName() String
        +getDoors int
        +getTrunkLiters() double
    }

    class Motorcycle {
        -engineCC : int
        -hasSidecar : boolean
        +Motorcycle(String brand, String model, int year, int engineCC, boolean hasSidecar, int serial)
        +generateUniqueIDBody(int serial) String
        +getTypeName() String
        +getEngineCC() int
        +hasSidecar() boolean
    }

    %% Relationships
    Filo "1" o-- "*" Vehicle : Aggregation (Fleet has Vehicles)
    Vehicle <|-- Car : Inheritance
    Vehicle <|-- Motorcycle : Inheritance
```

## Food Delivery System
**Folder:** `03_Food_Delivery_System`
* **Focus:** Interfaces, Custom Exceptions, Collections (HashMap), Polymorphism.
* **Description:** An ordering system connecting customers and products using interfaces. It features custom exception handling for cart management and uses HashMaps for efficient product lookup.

### UML Class Diagram

```mermaid
classDiagram
    class Main {
        +main(String[] args)
    }

    class Sellable {
        <<interface>>
        +getId() String
        +getName() String
        +getPrice() double
    }

    class Food {
        -id : String
        -name : String
        -price : double
        -restaurant : String
        +Food(String id, String name, double price, String restaurant)
        +toString() String
    }

    class Drink {
        -id : String
        -name : String
        -price : double
        -size : String
        +Drink(String id, String name, double price, String size)
        +toString() String
    }

    class FoodDeliveryPlatform {
        -products : HashMapString_Sellable
        +FoodDeliveryPlatform()
        +addProduct(Sellable product) void
        +getProduct(String id) Sellable
        +listProducts() void
        +searchByPriceRange(double min, double max) void
    }

    class Customer {
        -id : String
        -name : String
        -cart : ArrayList<Sellable>
        +Customer(String id, String name)
        +addToCart(Sellable item) void
        +removeFromCart(String itemId) void
        +showCartDetails() void
        +Payment() void
    }

    class ItemAlreadyinCartException {
        +ItemAlreadyinCartException(String message)
    }

    %% Relationships
    Sellable <|.. Food : Implements
    Sellable <|.. Drink : Implements
    Customer o-- Sellable : Aggregation (Cart contains Sellables)
    FoodDeliveryPlatform o-- Sellable : Aggregation (Map contains Sellables)
    Customer ..> ItemAlreadyinCartException : Throws
    Main ..> FoodDeliveryPlatform : Uses
    Main ..> Customer : Uses
