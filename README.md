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
        -companyName: String 
        -tours: Tour[] 
        -tickets: Ticket[] 
        -staff: Staff[]
        +Company(String, tourCount: int, ticketCount: int, staffCount: int)
        +addTour(tour: Tour): void
        +addTicket(ticket: Ticket): void
        +listTours(): void
        +listTickets(): void
        +searchTour(tourCity: String): void
        +showCitiesWithToursAndFlightsAvailable(): void
        +addStaff(staff: Staff): void
        +averageStaffSalary(): double
        +findOldestStaffAge(): int
    }

    class Tour {
        -tourName: String 
        -city: String
        -price: double
        +Tour(String, String, double)
        +getTourName(): String
        +getCity(): String
        +getPrice(): double
    }

    class Ticket {
        -departure: String
        -arrival: String 
        -airlineCompany: String
        -price: double
        +Ticket(String, String, String, double)
        +getDeparture(): String
        +getArrival(): String
        +getAirlineCompany(): String
        +getPrice(): double
    }

    class Staff {
        -name: String 
        -age: int
        -salary: double
        +Staff(String, int, double)
        +getName(): String
        +getAge(): int
        +getSalary(): double
    }

    %% Relationships
    Company "1" o-- "*" Staff : Aggregation
    Main ..> Company : Dependency
    Company "1" --> "*" Tour : Association
    Company "1" --> "*" Ticket : Association

# Vehicle Rental System

**Folder:** `02_Vehicle_Rental_System`  
**Focus:** Inheritance, Polymorphism, Abstraction, Encapsulation.

## Description
This project is a Java-based simulation of a **Vehicle Rental / Fleet Management System**. It demonstrates core **Object-Oriented Programming (OOP)** concepts such as Inheritance, Polymorphism, Abstraction, and Encapsulation.

## UML Class Diagram

```mermaid
classDiagram
    class Filo {
        -vehicles: Vehicle[]
        -vehicleCount: int
        -serialCounter: int
        +Filo(int capacity): void
        +addVehicle(Vehicle v): void
        +createCar(String brand, String model, int year, int doors, double trunkLiters): Car
        +createMotorcycle(String brand, String model, int year, int engineCC, boolean hasSidecar): Motorcycle
        +printAllVehicles(): void
        +printAvailable(): void
        +printAvailableByType(String typeName): void
        +findByID(String ID): Vehicle
        +rentByID(String ID): boolean
        +returnByID(String ID): boolean
    }

    class Vehicle {
        <<abstract>>
        #brand: String
        #model: String 
        #year: int
        #uniqueID: String 
        #rented: boolean 
        +Vehicle(String brand, String model, int year)
        +generateUniqueIDBody(int serial): String
        +getUniqueID(): String
        +isAvailable(): boolean
        +rent(): void
        +giveBack(): void
        +getTypeName(): String
        +toString(): String
    }

    class Car {
        -doors: int
        -trunkLiters: double
        +Car(String brand, String model, int year, int doors, double trunkLiters, int serial)
        +generateUniqueIDBody(int serial): String
        +getTypeName(): String
        +getDoors: ing
