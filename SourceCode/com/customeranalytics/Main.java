package com.customeranalytics;
import com.customeranalytics.processor.ComplaintProcessor;
import com.customeranalytics.processor.PaymentProcessor;
import com.customeranalytics.processor.DeliveryProcessor;
import com.customeranalytics.processor.GeneralProcessor;
import com.customeranalytics.model.Customer;
import com.customeranalytics.model.Complaint;
import com.customeranalytics.service.CustomerService;
import com.customeranalytics.service.ComplaintService;
import com.customeranalytics.analytics.AnalyticsEngine;
import com.customeranalytics.model.Feedback;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = new CustomerService();
    private static ComplaintService complaintService = new ComplaintService();
    private static ArrayList<Feedback> feedbackList = new ArrayList<>();
    private static AnalyticsEngine analyticsEngine = new AnalyticsEngine(complaintService.getComplaints(),feedbackList);

    private static String selectGeneralIssue(
            String title,
            String issue1,
            String issue2,
            String issue3) {

        System.out.println("\nSelect " + title + ":");
        System.out.println("1. " + issue1);
        System.out.println("2. " + issue2);
        System.out.println("3. " + issue3);

        System.out.print("Enter issue: ");

        int choice = Integer.parseInt(scanner.nextLine());

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
    }
    public static void main(String[] args) {

        boolean running = true;

        System.out.println("==============================================");
        System.out.println(" CUSTOMER FEEDBACK & COMPLAINT ANALYTICS");
        System.out.println("==============================================");

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
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
                System.out.println("\nPlease enter a valid number.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("----------------------------------------------");
        System.out.println("1. Customer Management");
        System.out.println("2. Complaint Management");
        System.out.println("3. Analytics & Reports");
        System.out.println("4. Exit");
        System.out.println("----------------------------------------------");
    }

    private static void customerMenu() {

        System.out.println("\n--- Customer Management ---");
        System.out.println("1. Add Customer");
        System.out.println("2. View Customers");
        System.out.println("3. Back");

        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {

            case 1:
                addCustomer();
                break;

            case 2:
                customerService.viewCustomers();
                break;

            case 3:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addCustomer() {

        System.out.print("Enter customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone);

        customerService.addCustomer(customer);
    }

    private static void complaintMenu() {

        System.out.println("\n--- Complaint Management ---");
        System.out.println("1. Register Complaint");
        System.out.println("2. View Complaints");
        System.out.println("3. Process Complaint");
        System.out.println("4. Update Complaint Status");
        System.out.println("5. Back");

        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

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
                updateComplaintStatus();
                break;

            case 5:
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void registerComplaint() {

        System.out.print("Enter complaint ID: ");
        int complaintId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(scanner.nextLine());

        Customer customer = customerService.findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found. Please add the customer first.");
            return;
        }

        System.out.println("\nSelect Category:");
        System.out.println("1. Payment");
        System.out.println("2. Delivery");
        System.out.println("3. Product");
        System.out.println("4. Technical");
        System.out.println("5. Account");
        System.out.println("6. Refund");
        System.out.println("7. Service");

        System.out.print("Enter category: ");
        int categoryChoice = Integer.parseInt(scanner.nextLine());

        String category;
        String issue;

        switch (categoryChoice) {

            case 1:
                category = "Payment";

                System.out.println("\nSelect Issue:");
                System.out.println("1. Payment Failed");
                System.out.println("2. Amount Deducted but Order Failed");
                System.out.println("3. Duplicate Payment");
                System.out.println("4. Payment Not Reflected");

                System.out.print("Enter issue: ");
                int paymentIssue = Integer.parseInt(scanner.nextLine());

                switch (paymentIssue) {
                    case 1:
                        issue = "Payment Failed";
                        break;
                    case 2:
                        issue = "Amount Deducted but Order Failed";
                        break;
                    case 3:
                        issue = "Duplicate Payment";
                        break;
                    case 4:
                        issue = "Payment Not Reflected";
                        break;
                    default:
                        System.out.println("Invalid issue.");
                        return;
                }
                break;

            case 2:
                category = "Delivery";

                System.out.println("\nSelect Issue:");
                System.out.println("1. Late Delivery");
                System.out.println("2. Wrong Address");
                System.out.println("3. Package Damaged");
                System.out.println("4. Package Not Received");
                System.out.println("5. Tracking Issue");

                System.out.print("Enter issue: ");
                int deliveryIssue = Integer.parseInt(scanner.nextLine());

                switch (deliveryIssue) {
                    case 1:
                        issue = "Late Delivery";
                        break;
                    case 2:
                        issue = "Wrong Address";
                        break;
                    case 3:
                        issue = "Package Damaged";
                        break;
                    case 4:
                        issue = "Package Not Received";
                        break;
                    case 5:
                        issue = "Tracking Issue";
                        break;
                    default:
                        System.out.println("Invalid issue.");
                        return;
                }
                break;

            case 3:
                category = "Product";
                issue = selectGeneralIssue("Product Issue",
                        "Damaged Product",
                        "Wrong Product",
                        "Product Quality Issue"
                );

                if (issue == null) {
                    return;
                }

                break;

            case 4:
                category = "Technical";
                issue = selectGeneralIssue(
                        "Technical Issue",
                        "App Not Working",
                        "Website Problem",
                        "Login Problem"
                );
                if (issue == null) return;
                break;

            case 5:
                category = "Account";
                issue = selectGeneralIssue(
                        "Account Issue",
                        "Unable to Login",
                        "Account Locked",
                        "Profile Problem"
                );
                if (issue == null) return;
                break;

            case 6:
                category = "Refund";
                issue = selectGeneralIssue("Refund Issue", "Refund Delayed", "Refund Not Received", "Wrong Refund Amount");
                if (issue == null) return;
                break;

            case 7:
                category = "Service";
                issue = selectGeneralIssue("Service Issue", "Poor Service", "Staff Behaviour", "Service Delay");
                if (issue == null) return;
                break;

            default:
                System.out.println("Invalid category.");
                return;
        }

        Complaint complaint = new Complaint(
                complaintId,
                customerId,
                category,
                issue
        );

        complaintService.addComplaint(complaint);

        System.out.println("\nComplaint registered successfully.");
    }

    private static void updateComplaintStatus() {

        System.out.print("Enter complaint ID: ");
        int complaintId = Integer.parseInt(scanner.nextLine());

        Complaint complaint = complaintService.findComplaint(complaintId);

        if (complaint == null) {
            System.out.println("Complaint not found.");
            return;
        }

        System.out.println("1. Pending");
        System.out.println("2. In Progress");
        System.out.println("3. Resolved");

        System.out.print("Select status: ");
        int statusChoice = Integer.parseInt(scanner.nextLine());

        switch (statusChoice) {

            case 1:
                complaint.setStatus("Pending");
                break;

            case 2:
                complaint.setStatus("In Progress");
                break;

            case 3:

                complaint.setStatus("Resolved");

                System.out.print("Enter resolution time in hours: ");
                double time = Double.parseDouble(scanner.nextLine());

                if (time < 0) {
                    System.out.println("Resolution time cannot be negative.");
                    return;
                }

                complaint.setResolutionTime(time);

                collectFeedback(complaint.getCustomerId());

                break;

            default:
                System.out.println("Invalid status.");
                return;
        }

        System.out.println("Complaint status updated.");
    }

        private static void processComplaint() {

            System.out.print("Enter complaint ID: ");
            int complaintId = Integer.parseInt(scanner.nextLine());

            Complaint complaint = complaintService.findComplaint(complaintId);

            if (complaint == null) {
                System.out.println("Complaint not found.");
                return;
            }

            ComplaintProcessor processor;

            if (complaint.getCategory().equals("Payment")) {

                processor = new PaymentProcessor();

            } else if (complaint.getCategory().equals("Delivery")) {

                processor = new DeliveryProcessor();

            } else {

                processor = new GeneralProcessor();
            }

            processor.processComplaint(complaint);
        }

    private static void analyticsMenu() {

        System.out.println("\n--- Analytics & Reports ---");
        System.out.println("1. Total Complaints");
        System.out.println("2. Complaint Status");
        System.out.println("3. Complaints by Category");
        System.out.println("4. Complaint Priority");
        System.out.println("5. Average Resolution Time");
        System.out.println("5. Average Customer rating");
        System.out.println("6. Generate Full Report");
        System.out.println("7. Back");

        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

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
    }

    private static void collectFeedback(int customerId) {

        System.out.println("\n--- Customer Feedback ---");

        System.out.print("Enter rating (1-5): ");
        int rating = Integer.parseInt(scanner.nextLine());

        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }

        System.out.print("Enter feedback: ");
        String comment = scanner.nextLine();

        if (comment.trim().isEmpty()) {
            System.out.println("Feedback cannot be empty.");
            return;
        }

        Feedback feedback = new Feedback(
                customerId,
                rating,
                comment
        );

        feedbackList.add(feedback);

        System.out.println("Feedback recorded successfully.");
    }


}