package com.customeranalytics.processor;
import com.customeranalytics.model.Complaint;
    public abstract class ComplaintProcessor {
        public abstract void processComplaint(Complaint complaint);
        protected void setPriority(Complaint complaint, String priority) {
            complaint.setPriority(priority);
        }
    }

