package com.customeranalytics.analytics;
import com.customeranalytics.model.Complaint;
import com.customeranalytics.model.Feedback;

import java.util.ArrayList;

public class AnalyticsEngine {
    private ArrayList<Complaint> complaints;
    private ArrayList<Feedback> feedbackList;
    public AnalyticsEngine(ArrayList<Complaint> complaints,
                           ArrayList<Feedback> feedbackList) {
        this.complaints = complaints;
        this.feedbackList = feedbackList;
    }

    public void showTotalComplaints() {  //displays the total number of complaints registered

        System.out.println("\n--- Total Complaints ---");
        System.out.println("Total Complaints: " + complaints.size());
    }

    public void showStatusAnalysis() {  //counts complaints according to their current status
        int pending = 0;
        int inProgress = 0;
        int resolved = 0;

        for (Complaint complaint : complaints) {
            switch (complaint.getStatus()) {
                case "Pending":
                    pending++;
                    break;
                case "In Progress":
                    inProgress++;
                    break;
                case "Resolved":
                    resolved++;
                    break;
            }
        }
        System.out.println("\n--- Complaint Status ---");
        System.out.println("Pending: " + pending);
        System.out.println("In Progress: " + inProgress);
        System.out.println("Resolved: " + resolved);
    }

    public void showCategoryAnalysis() {  // counts no. of complaints according to category.
        int payment = 0;
        int delivery = 0;
        int product = 0;
        int technical = 0;
        int account = 0;
        int refund = 0;
        int service = 0;

        for (Complaint complaint : complaints) {
            switch (complaint.getCategory()) {
                case "Payment":
                    payment++;
                    break;
                case "Delivery":
                    delivery++;
                    break;
                case "Product":
                    product++;
                    break;
                case "Technical":
                    technical++;
                    break;
                case "Account":
                    account++;
                    break;
                case "Refund":
                    refund++;
                    break;
                case "Service":
                    service++;
                    break;
            }
        }

        System.out.println("\n--- Complaints by Category ---");
        System.out.println("Payment: " + payment);
        System.out.println("Delivery: " + delivery);
        System.out.println("Product: " + product);
        System.out.println("Technical: " + technical);
        System.out.println("Account: " + account);
        System.out.println("Refund: " + refund);
        System.out.println("Service: " + service);
