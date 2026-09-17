# Customer-feedback-complaint-analytics-system
The Customer Feedback & Complaint Analytics System is a Java-based console application designed to manage customer complaints, process them based on predefined categories, and generate useful analytics and reports.
The project demonstrates core Java programming and Object-Oriented Programming (OOP) concepts through a simple and practical customer service management system.

## Features
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

## Technologies and Tools Used
- **Java** – Main programming language.
- **IntelliJ IDEA** – Development environment.
- **Git** – Version control.
- **GitHub** – Source code repository.

## Installation and Setup
Prerequisites
Make sure the following are installed:
- Java JDK 8 or above
- IntelliJ IDEA
- Git (optional, if cloning the project using Git)

**Method 1: Open the Project in IntelliJ IDEA**
- Download or clone the project repository.
- Open IntelliJ IDEA.
- Select File → Open.
- Select the project folder.
- Make sure the Java source files are recognized by IntelliJ.
- Open Main.java.
  
**Method 2: Clone Using Git**
Open a terminal and run:git clone <repository-url>
Then:
- Open the cloned project folder in IntelliJ IDEA.
- Locate Main.java.
- Make sure the project is configured with a suitable Java JDK.
- Run the Main.java file.

**Running the Project**
The application is a console-based Java application.To run the project:
- Open Main.java in IntelliJ IDEA.
- Click the green Run button next to the main() method.
- The main menu will appear in the console.

## Testing Instructions
The application can be tested directly through the IntelliJ console.
**Test 1: Add Customer**
- Select Customer Management.
- Select Add Customer.
- Enter a Customer ID, name, email, and phone number.
- Select View Customers to verify that the customer was added.

**Test 2: Register Complaint**
- Select Complaint Management.
- Select Register Complaint.
- Enter a valid Customer ID.
- Select a complaint category.
- Select one of the predefined issues.
- Verify the complaint using View Complaints.
  
**Test 3: Process Complaint**
- Select Process Complaint.
- Enter a valid Complaint ID.
- The system selects the appropriate processor based on the complaint category.
- Verify that the complaint status changes to In Progress.
- Verify the assigned priority.
  
**Test 4: Update Complaint Status**
- Select Update Complaint Status.
- Enter the Complaint ID.
- Select the required status:
  - Pending
  - In Progress
  - Resolved
- Verify the updated complaint using View Complaints.
  
**Test 5: Customer Feedback**
- Resolve a complaint.
- Enter the resolution time.
- Enter a customer rating between 1 and 5.
- Enter feedback comments.
- Check Analytics & Reports to verify the average customer rating.
  
**Test 6: Analytics**
- Add multiple customers and complaints.
- Process and resolve some complaints.
- Open Analytics & Reports.
- Test:
  - Total Complaints
  - Complaint Status
  - Complaints by Category
  - Complaint Priority
  - Average Resolution Time
  - Average Customer Rating
  - Generate Full Report

## Srcreenshots
### 1.
<img width="1256" height="860" alt="Screenshot 2026-09-17 125620" src="https://github.com/user-attachments/assets/6f8eda38-67fe-4e33-ac4f-966c11c705e6" />

### 2.
<img width="816" height="897" alt="Screenshot 2026-09-17 125636" src="https://github.com/user-attachments/assets/25a4fe63-08f2-4d20-9722-afeb41e02062" />

### 3.
<img width="755" height="872" alt="Screenshot 2026-09-17 170625" src="https://github.com/user-attachments/assets/cc3f0bb1-d5af-4a15-867e-28114b17e208" />

### 4.
<img width="706" height="872" alt="Screenshot 2026-09-17 170649" src="https://github.com/user-attachments/assets/7da5ff22-41fe-4f51-89f8-2b9a7716c193" />
