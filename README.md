# Customer-feedback-complaint-analytics-system
The Customer Feedback & Complaint Analytics System is a Java-based console application designed to manage customer complaints, process them based on predefined categories, and generate useful analytics and reports.
The project demonstrates core Java programming and Object-Oriented Programming (OOP) concepts through a simple and practical customer service management system.

## Objectives
- Manage customer information.
- Register and view customer complaints.
- Categorize complaints using predefined categories and issues.
- Process complaints using category-based processing.
- Assign complaint priorities.
- Update complaint status.
- Collect customer feedback and ratings.
- Generate complaint analytics and reports.

## Modules
### 1. Customer & Complaint Management
This module handles basic customer and complaint operations.

**Customer Management**
- Add a new customer.
- View all customers.
- Search customers using Customer ID.

**Complaint Management**
- Register a complaint.
- Select a predefined complaint category and issue.
- View all complaints.
- Search complaints using Complaint ID.
- Update complaint status.
- Process complaints.

### 2. Complaint Processing
This module processes complaints according to their category.Predefined complaint categories include:
- Payment
- Delivery
- Product
- Technical
- Account
- Refund
- Service

Payment and delivery complaints use category-specific processors, while other categories are handled by a general processor.
The system also assigns a priority:
- High
- Normal
Complaint processing demonstrates **inheritance, abstraction, method overriding, and runtime polymorphism**.

### 3. Analytics & Reports
This module provides basic statistics about complaints and customer feedback.The system can generate:
- Total number of complaints.
- Complaints by category.
- Complaints by status.
- Complaints by priority.
- Average resolution time.
- Average customer rating.
- Full complaint report.

## Technologies Used
- Java
- IntelliJ IDEA
- Git & GitHub

## Java Concepts Demonstrated
The project focuses on fundamental Java and OOP concepts, including:
- Classes and Objects
- Encapsulation
- Constructors
- Inheritance
- Abstraction
- Polymorphism
- Method Overriding
- ArrayList
- HashMap
- Exception Handling
- Conditional Statements
- Loops
- Switch Statements
- Input Validation
