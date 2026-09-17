package com.customeranalytics.model;
public class Feedback {  //feedback is linked to the customer 
    private int customerId;
    private int rating;
    private String comment;

    public Feedback(int customerId, int rating, String comment) {  //constructor
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getCustomerId() {
        return customerId;
    }
    public int getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }
}
