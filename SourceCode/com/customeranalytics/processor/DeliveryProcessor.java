package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;
//handles complaints related to delivery
public class DeliveryProcessor extends ComplaintProcessor {
    @Override   // Inheritance
    public void processComplaint(Complaint complaint) {
        if (complaint.getIssue().equals("Package not received") || complaint.getIssue().equals("Package damaged")) {
            setPriority(complaint, "High");
        } else {
            setPriority(complaint, "Normal");
        }
        complaint.setStatus("In Progress");
        System.out.println("Delivery complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}
