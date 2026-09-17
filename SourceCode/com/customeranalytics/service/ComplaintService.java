package com.customeranalytics.service;
import com.customeranalytics.model.Complaint;
import java.util.ArrayList;

public class ComplaintService {  //stores all complaints registered.
    private ArrayList<Complaint> complaints = new ArrayList<>();
    
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
        System.out.println("Complaint registered successfully.");
    }
    public void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }
        for (Complaint complaint : complaints) {
            System.out.println("-------------------------");
            complaint.displayComplaint();
        }
    }
    public Complaint findComplaint(int complaintId) {
        for (Complaint complaint : complaints) {
            if (complaint.getComplaintId() == complaintId) {
                return complaint;
            }
        }
        return null;  //if complaint doesnt exist
    }
    public void updateStatus(int complaintId, String status) {
        Complaint complaint = findComplaint(complaintId);
        if (complaint != null) {
            complaint.setStatus(status);
            System.out.println("Complaint status updated.");
        } else {
            System.out.println("Complaint not found.");
        }
    }

    public ArrayList<Complaint> getComplaints() {  //gives the Analytics module access to the complaint list.
        return complaints;
    }
}              
