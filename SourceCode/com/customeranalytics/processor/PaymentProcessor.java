package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;

public class PaymentProcessor extends ComplaintProcessor {  //complaints related to payments
    @Override  //inheritacne
    public void processComplaint(Complaint complaint) {
        //payment failures can affect an order directly,so these are given higher priority.
        if (complaint.getIssue().equals("Payment Failed") || complaint.getIssue().equals("Amount Deducted but Order Failed")) {
            setPriority(complaint, "High");
        } else {
            setPriority(complaint, "Normal");
        }
        complaint.setStatus("In Progress");
        System.out.println("Payment complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}
