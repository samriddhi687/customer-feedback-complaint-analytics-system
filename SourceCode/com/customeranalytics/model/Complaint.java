package com.customeranalytics.model;
public class Complaint {
    private int complaintId;
    private int customerId;
    private String category;
    private String issue;
    private String status;
    private String priority;
    private double resolutionTime;

    public Complaint(int complaintId, int customerId,
                     String category, String issue) {

        this.complaintId = complaintId;
        this.customerId = customerId;
        this.category = category;
        this.issue = issue;
        this.status = "Pending";
        this.priority = "Normal";
        this.resolutionTime = 0;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCategory() {
        return category;
    }

    public String getIssue() {
        return issue;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getResolutionTime() {
        return resolutionTime;
    }
    public void setResolutionTime(double resolutionTime) {
        this.resolutionTime = resolutionTime;
    }

    public void displayComplaint() {
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Category: " + category);
        System.out.println("Issue: " + issue);
        System.out.println("Status: " + status);
        System.out.println("Priority: " + priority);
        System.out.println("Resolution Time: " + resolutionTime + " hours");
    }
}