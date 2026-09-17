package com.customeranalytics.model;
public class Feedback {
    private int customerId;
    private int rating;
    private String comment;

    public Feedback(int customerId, int rating, String comment){
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getCustomerId(){
        return customerId;
    }

    public int getRating(){
        return rating;
    }

    public String getComment(){
        return comment;
    }
}
