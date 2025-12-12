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
