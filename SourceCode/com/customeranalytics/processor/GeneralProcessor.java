package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;

public class GeneralProcessor extends ComplaintProcessor {  //handles complaints that do not need a category-specific processor
    @Override
    public void processComplaint(Complaint complaint) {
        setPriority(complaint, "Normal");  //priority set to Normal.
        complaint.setStatus("In Progress");
        System.out.println("Complaint processed.");
        System.out.println("Priority: " + complaint.getPriority());
    }
}
