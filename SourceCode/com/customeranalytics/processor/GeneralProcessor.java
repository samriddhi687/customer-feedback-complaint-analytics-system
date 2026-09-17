package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;
public class GeneralProcessor extends ComplaintProcessor {
    @Override
    public void processComplaint(Complaint complaint) {
        setPriority(complaint, "Normal");
        complaint.setStatus("In Progress");

        System.out.println("Complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}