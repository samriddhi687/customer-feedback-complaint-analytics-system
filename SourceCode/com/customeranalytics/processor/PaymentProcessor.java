package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;
public class PaymentProcessor extends ComplaintProcessor {
    @Override
    public void processComplaint(Complaint complaint) {
        if (complaint.getIssue().equals("Payment Failed")
                || complaint.getIssue().equals("Amount Deducted but Order Failed")) {
            setPriority(complaint, "High");
        } else {
            setPriority(complaint, "Normal");
        }
        complaint.setStatus("In Progress");

        System.out.println("Payment complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}