# Library Management System

A Java-based Library Management System that allows libraries to manage their book inventory and patron interactions efficiently.

## Features

- Book Management
  - Add new books to inventory
  - Track book availability
  - Maintain book details (ID, title, author, ISBN, publication year)

- Patron Management
  - Enroll new patrons
  - Store patron information (ID, name, phone number, email)
  - Track patron's book borrowing history

- Book Lending
  - Issue books to patrons
  - Process book returns
  - Track current books issued to patrons
  - Maintain lending history

## Project Structure

```
src/
├── LibraryManagementSystem.java    # Main application entry point
├── books/
│   └── Book.java                   # Book entity class
├── Library/
│   └── Library.java                # Core library operations
├── managers/
│   ├── BookInventoryManager.java   # Handles book inventory
│   ├── BookIssueManager.java       # Manages book lending
│   └── PatronManager.java          # Manages patron data
└── patrons/
    └── Patron.java                 # Patron entity class
```

## Getting Started

1. Clone the repository
2. Open the project in your preferred Java IDE
3. Run the `LibraryManagementSystem.java` file

## Usage Example

```java
// Create a new library instance
Library library = new Library("City Library 1", "123 India", "999999999");

// Enroll a patron
Patron patron = library.enrollPatron(1, "John Doe", "8888888888", "john@doe.com");

// Add a book to inventory
Book book = library.addBookToInventory(101, "My book 1", "F. Scott Fitzgerald", "9780743273565", 1925);

// Issue book to patron
boolean issueStatus = library.issueBookToPatron(book, patron);
```

## Development

This project is developed in Java and follows object-oriented programming principles, with separate modules for different functionalities to ensure maintainability and scalability.

## System Requirements

- Java Development Kit (JDK)
- Any Java IDE (IntelliJ IDEA recommended)

## Class Diagram

The detailed class diagram of the system is available in the `LibraryManagementClassDiagram.puml` file at the root level of the project. This PlantUML file contains a comprehensive visualization of:

- All system classes with their attributes and methods
- Relationships between different components
- Multiplicity of relationships (one-to-one, one-to-many)
- Clear representation of the system architecture

To view the class diagram:
1. Open the `LibraryManagementClassDiagram.puml` file
2. Use a PlantUML viewer/extension in your IDE
3. Or use the [PlantUML Web Server](http://www.plantuml.com/plantuml/uml/)

The diagram shows the following key components and their relationships:
- Library (main controller class)
- Book (entity class)
- Patron (entity class)
- BookInventoryManager (manages book inventory)
- BookIssueManager (handles book lending)
- PatronManager (manages patron data)
