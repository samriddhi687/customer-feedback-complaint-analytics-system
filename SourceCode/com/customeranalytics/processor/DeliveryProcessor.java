package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;
public class DeliveryProcessor extends ComplaintProcessor {
    @Override
    public void processComplaint(Complaint complaint) {
        if (complaint.getIssue().equals("Package Not Received")
                || complaint.getIssue().equals("Package Damaged")) {

            setPriority(complaint, "High");
        } else {
            setPriority(complaint, "Normal");
        }
        complaint.setStatus("In Progress");

        System.out.println("Delivery complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}