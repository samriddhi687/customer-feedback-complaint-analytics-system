package com.customeranalytics;

import com.customeranalytics.analytics.AnalyticsEngine;
import com.customeranalytics.model.Complaint;
import com.customeranalytics.model.Customer;
import com.customeranalytics.model.Feedback;
import com.customeranalytics.processor.ComplaintProcessor;
import com.customeranalytics.processor.DeliveryProcessor;
import com.customeranalytics.processor.GeneralProcessor;
import com.customeranalytics.processor.PaymentProcessor;
import com.customeranalytics.service.ComplaintService;
import com.customeranalytics.service.CustomerService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static CustomerService customerService = new CustomerService();  //services handle customer and
    private static ComplaintService complaintService = new ComplaintService();   // complaint related operations
    private static ArrayList<Feedback> feedbackList = new ArrayList<>();  //stores feedback given by customers
    private static AnalyticsEngine analyticsEngine = new AnalyticsEngine( complaintService.getComplaints(),feedbackList);  //analytics engine uses the complaint & feedback data

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("==============================================");
        System.out.println(" Customer Feedback & Complaint Analytics System");
        System.out.println("==============================================");

        while (running) {
            displayMenu();  
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        customerMenu();
                        break;
                    case 2:
                        complaintMenu();
                        break;
                    case 3:
                        analyticsMenu();
                        break;
                    case 4:
                        running = false;
                        System.out.println("\nThank you for using the system.");
                        break;
                    default:
                        System.out.println("\nPlease select a number from 1 to 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        sc.close();
    }
    private static void displayMenu() {  //main menu
        System.out.println("\n----------------------------------------------");
        System.out.println("1. Customer Management");
        System.out.println("2. Complaint Management");
        System.out.println("3. Analytics & Reports");
        System.out.println("4. Exit");
        System.out.println("----------------------------------------------");
    }

    private static void customerMenu() {  //Menu for customer-related operations.
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Customer Management ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        customerService.viewCustomers();
                        break;
                    case 3:
                        searchCustomer();
                        break;
                    case 4:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static void addCustomer() {  //creates a new Customer object with customer details
        try {
            System.out.print("\nEnter customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());

            if (customerService.findCustomer(customerId) != null) {
                System.out.println("Customer ID already exists.");
                return;
            }
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            
            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            Customer customer = new Customer(customerId,name,email,phone);
            customerService.addCustomer(customer);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid customer ID.");
        }
    }
    
    private static void searchCustomer() {
        try {
            System.out.print("\nEnter customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());
            Customer customer = customerService.findCustomer(customerId);
            if (customer != null) {
                System.out.println("\nCustomer found:");
                customer.displayCustomer();
            } else {
                System.out.println("Customer not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid customer ID.");
        }
    }

    private static void complaintMenu() {   //this is the menu for complaint-related operations
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Complaint Management ---");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Process Complaint");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        registerComplaint();
                        break;
                    case 2:
                        complaintService.viewComplaints();
                        break;
                    case 3:
                        processComplaint();
                        break;
                    case 4:
                        back = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static void registerComplaint() {  //rsigisters new complaint for an existing customer
        try {
            System.out.print("\nEnter complaint ID: ");
            int complaintId = Integer.parseInt(sc.nextLine());
            if (complaintService.findComplaint(complaintId) != null) {
                System.out.println("Complaint ID already exists.");
                return;
            }
            System.out.print("Enter customer ID: ");
            int customerId = Integer.parseInt(sc.nextLine());
            if (customerService.findCustomer(customerId) == null) {  //complaint registration valid for an exisitng customer
                System.out.println("Customer not found. Please add the customer first.");
                return;
            }
            System.out.println("\nSelect complaint category:");
            System.out.println("1. Payment");
            System.out.println("2. Delivery");
            System.out.println("3. Product");
            System.out.println("4. Technical");
            System.out.println("5. Account");
            System.out.println("6. Refund");
            System.out.println("7. Service");
            System.out.print("Enter category: ");
            int categoryChoice = Integer.parseInt(sc.nextLine());

            String category;
            String issue;
            switch (categoryChoice) {
                case 1:
                    category = "Payment";
                    issue = selectGeneralIssue("Payment Issue","Payment Failed","Amount Deducted but Order Failed","Duplicate Payment");
                    break;
                case 2:
                    category = "Delivery";
                    issue = selectDeliveryIssue();
                    break;
                case 3:
                    category = "Product";
                    issue = selectGeneralIssue("Product Issue","Damaged Product","Wrong Product","Product Quality Issue");
                    break;
                case 4:
                    category = "Technical";
                    issue = selectGeneralIssue("Technical Issue","App Not Working","Website Problem","Login Problem");
                    break;
                case 5:
                    category = "Account";
                    issue = selectGeneralIssue("Account Issue","Unable to Login","Account Locked","Profile Problem");
                    break;
                case 6:
                    category = "Refund";
                    issue = selectGeneralIssue("Refund Issue","Refund Delayed","Refund Not Received","Wrong Refund Amount");
                    break;
                case 7:
                    category = "Service";
                    issue = selectGeneralIssue("Service Issue","Poor Service","Staff Behaviour","Service Delay");
                    break;
                default:
                    System.out.println("Invalid category.");
                    return;
            }
            if (issue == null) {
                return;
            }
            Complaint complaint = new Complaint(complaintId,customerId,category,issue );
            complaintService.addComplaint(complaint);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
    
    private static String selectGeneralIssue( String title, String issue1, String issue2, String issue3) {
        System.out.println("\nSelect " + title + ":");
        System.out.println("1. " + issue1);
        System.out.println("2. " + issue2);
        System.out.println("3. " + issue3);
        System.out.print("Enter issue: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    return issue1;
                case 2:
                    return issue2;
                case 3:
                    return issue3;
                default:
                    System.out.println("Invalid issue.");
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return null;
        }
    }
    private static String selectDeliveryIssue() {
        System.out.println("\nSelect Delivery Issue:");
        System.out.println("1. Late Delivery");
        System.out.println("2. Wrong Address");
        System.out.println("3. Package Damaged");
        System.out.println("4. Package Not Received");
        System.out.println("5. Tracking Issue");
        System.out.print("Enter issue: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    return "Late Delivery";
                case 2:
                    return "Wrong Address";
                case 3:
                    return "Package Damaged";
                case 4:
                    return "Package Not Received";
                case 5:
                    return "Tracking Issue";
                default:
                    System.out.println("Invalid issue.");
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return null;
        }
    }

    private static void processComplaint() {
    try {
        System.out.print("\nEnter complaint ID: ");
        int complaintId = Integer.parseInt(sc.nextLine());
        Complaint complaint =complaintService.findComplaint(complaintId);
        if (complaint == null) {
            System.out.println("Complaint not found.");
            return;
        }
        ComplaintProcessor processor;
        if (complaint.getCategory().equals("Payment")) {  //seleecting the processor according to the complaint category
            processor = new PaymentProcessor();
        } else if (complaint.getCategory().equals("Delivery")) {
            processor = new DeliveryProcessor();
        } else {
            processor = new GeneralProcessor();
        }
        processor.processComplaint(complaint);
        System.out.println("\nComplaint is now In Progress.");
        System.out.println("1. Resolve Complaint");
        System.out.println("2. Keep In Progress");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            System.out.print("Enter resolution time in hours: ");
            double time = Double.parseDouble(sc.nextLine());
            if (time < 0) {
                System.out.println("Resolution time cannot be negative.");
                return;
            }
            complaint.setResolutionTime(time);
            complaint.setStatus("Resolved");
            collectFeedback(complaint.getCustomerId());
            System.out.println("Complaint resolved successfully.");
        } else if (choice == 2) {
            System.out.println("Complaint remains In Progress.");
        } else {
            System.out.println("Invalid choice.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
    }
}
    private static void collectFeedback(int customerId) {
        System.out.println("\n--- Customer Feedback ---");
        try {
            System.out.print("Enter rating (1-5): ");
            int rating = Integer.parseInt(sc.nextLine());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be between 1 and 5.");
                return;
            }
            System.out.print("Enter feedback: ");
            String comment = sc.nextLine();
            if (comment.trim().isEmpty()) {
                System.out.println("Feedback cannot be empty.");
                return;
            }
            Feedback feedback =new Feedback(customerId, rating, comment);
            feedbackList.add(feedback);
            System.out.println("Feedback recorded successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid rating.");
        }
    }
    private static void analyticsMenu() {
        System.out.println("\n--- Analytics & Reports ---");
        System.out.println("1. Total Complaints");
        System.out.println("2. Complaint Status");
        System.out.println("3. Complaints by Category");
        System.out.println("4. Complaint Priority");
        System.out.println("5. Average Resolution Time");
        System.out.println("6. Average Customer Rating");
        System.out.println("7. Generate Full Report");
        System.out.println("8. Back");
        System.out.print("Enter your choice: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    analyticsEngine.showTotalComplaints();
                    break;
                case 2:
                    analyticsEngine.showStatusAnalysis();
                    break;
                case 3:
                    analyticsEngine.showCategoryAnalysis();
                    break;
                case 4:
                    analyticsEngine.showPriorityAnalysis();
                    break;
                case 5:
                    analyticsEngine.showAverageResolutionTime();
                    break;
                case 6:
                    analyticsEngine.showAverageRating();
                    break;
                case 7:
                    analyticsEngine.generateReport();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
