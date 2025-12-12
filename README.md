# oop_learning_projects
My OOP learning journey. Demonstrates OOP concepts through code examples and class design.

## Travel Agency System
**Folder:** `01_Travel_Agency_System`
* **Focus:** Aggregation, Dependency, Association relationships.
* **Description:** A system managing tours, tickets, and staff using separate classes.

### UML Class Diagram
```mermaid
classDiagram
    class Main {
        +main(String[] args)
    }

    class Company {
        -String companyName
        -Tour[] tours
        -Ticket[] tickets
        -Staff[] staff
        +addTour(Tour tour)
        +addTicket(Ticket ticket)
        +addStaff(Staff staff)
        +searchTour(String city)
        +averageStaffSalary() double
    }

    class Tour {
        -String tourName
        -String city
        -double price
    }

    class Ticket {
        -String departure
        -String arrival
        -String airlineCompany
        -double price
    }

    class Staff {
        -String name
        -int age
        -double salary
    }

    %% Relationships
    Company "1" o-- "*" Staff : Aggregation
    Main ..> Company : Dependency
    Company "1" --> "*" Tour : Association
    Company "1" --> "*" Ticket : Association
