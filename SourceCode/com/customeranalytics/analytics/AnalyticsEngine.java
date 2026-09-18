package com.customeranalytics.analytics;
import com.customeranalytics.model.Complaint;
import com.customeranalytics.model.Feedback;

import java.util.ArrayList;
public class AnalyticsEngine {
    private ArrayList<Complaint> complaints;
    private ArrayList<Feedback> feedbackList;
    public AnalyticsEngine(ArrayList<Complaint> complaints, ArrayList<Feedback> feedbackList) {
        this.complaints = complaints;
        this.feedbackList = feedbackList;
    }

    public void showTotalComplaints() {
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
    
    public void showCategoryAnalysis() {
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
    }

    public void showPriorityAnalysis() {  //shows how many complaints are High or Normal priority
        int high = 0;
        int normal = 0;
        for (Complaint complaint : complaints) {
            if (complaint.getPriority().equals("High")) {
                high++;
            } else {
                normal++;
            }
        }
        System.out.println("\n--- Complaint Priority ---");
        System.out.println("High: " + high);
        System.out.println("Normal: " + normal);
    }
    
    public void showAverageResolutionTime() {
        double totalTime = 0;
        int resolvedComplaints = 0;
        for (Complaint complaint : complaints) {
            if (complaint.getStatus().equals("Resolved")) {
                totalTime += complaint.getResolutionTime();
                resolvedComplaints++;
            }
        }
        System.out.println("\n--- Resolution Time ---");
        if (resolvedComplaints == 0) {  //avoids division by zero when there are no resolved complaints
            System.out.println("No resolved complaints available.");
        } else {
            double average = totalTime / resolvedComplaints;
            System.out.printf(
                    "Average Resolution Time: %.2f hours%n",
                    average
            );
        }
    }
    
    public void showAverageRating() {
        System.out.println("\n--- Customer Rating ---");
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }
        int totalRating = 0;
        for (Feedback feedback : feedbackList) {
            totalRating += feedback.getRating();
        }
        double average = (double) totalRating / feedbackList.size();
        System.out.printf(
                "Average Customer Rating: %.2f / 5%n",
                average
        );
    }

    public void generateReport() {   //Displays all the important analytics together.
        System.out.println("\n================================");
        System.out.println(" CUSTOMER COMPLAINT REPORT");
        System.out.println("================================");
        showTotalComplaints();
        showStatusAnalysis();
        showCategoryAnalysis();
        showPriorityAnalysis();
        showAverageResolutionTime();
        showAverageRating();
        System.out.println("================================");
    }
}
