package com.customeranalytics.model;
public class Customer {  //basic information about the customer
    private int customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(int customerId, String name, String email, String phone) {  //constructor used to create a new customer
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomerId() {  //to access customer details
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}
