package com.customeranalytics.analytics;

import com.customeranalytics.model.Complaint;
import com.customeranalytics.model.Feedback;

import java.util.ArrayList;
import java.util.HashMap;

public class AnalyticsEngine {

    private ArrayList<Complaint> complaints;

    private ArrayList<Feedback> feedbackList;

    public AnalyticsEngine(
            ArrayList<Complaint> complaints,
            ArrayList<Feedback> feedbackList) {

        this.complaints = complaints;
        this.feedbackList = feedbackList;
    }

    public void showTotalComplaints() {

        System.out.println("Total Complaints: " + complaints.size());
    }

    public void showStatusAnalysis() {

        int pending = 0;
        int inProgress = 0;
        int resolved = 0;

        for (Complaint complaint : complaints) {

            if (complaint.getStatus().equals("Pending")) {
                pending++;
            }
            else if (complaint.getStatus().equals("In Progress")) {
                inProgress++;
            }
            else if (complaint.getStatus().equals("Resolved")) {
                resolved++;
            }
        }

        System.out.println("\n--- Complaint Status ---");
        System.out.println("Pending: " + pending);
        System.out.println("In Progress: " + inProgress);
        System.out.println("Resolved: " + resolved);
    }

    public void showCategoryAnalysis() {

        HashMap<String, Integer> categoryCount = new HashMap<>();

        for (Complaint complaint : complaints) {

            String category = complaint.getCategory();

            if (categoryCount.containsKey(category)) {
                categoryCount.put(
                        category,
                        categoryCount.get(category) + 1
                );
            }
            else {
                categoryCount.put(category, 1);
            }
        }

        System.out.println("\n--- Complaints by Category ---");

        for (String category : categoryCount.keySet()) {
            System.out.println(
                    category + ": " + categoryCount.get(category)
            );
        }
    }

    public void showPriorityAnalysis() {

        int high = 0;
        int normal = 0;

        for (Complaint complaint : complaints) {

            if (complaint.getPriority().equals("High")) {
                high++;
            }
            else {
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

        if (resolvedComplaints == 0) {
            System.out.println("No resolved complaints available.");
        }
        else {
            double average = totalTime / resolvedComplaints;

            System.out.printf(
                    "Average Resolution Time: %.2f hours%n",
                    average
            );
        }
    }

    public void generateReport() {

        System.out.println("\n================================");
        System.out.println(" CUSTOMER COMPLAINT REPORT");
        System.out.println("================================");

        showTotalComplaints();
        showStatusAnalysis();
        showCategoryAnalysis();
        showPriorityAnalysis();
        showAverageResolutionTime();
        showCategoryAnalysis();

        System.out.println("================================");
    }

    public void showAverageRating() {

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
}