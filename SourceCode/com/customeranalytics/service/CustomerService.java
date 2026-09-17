package com.customeranalytics.service;
import com.customeranalytics.model.Customer;

import java.util.ArrayList;
public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();  //stores all the customers added to the system

    public void addCustomer(Customer customer) {  //adds new customer
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void viewCustomers() {  //displays all customers currently stored
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println("---------------------------------");
            customer.displayCustomer();
        }
    }
   
    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {  //id used
                return customer;
            }
        }
        return null;  //if no customer with the given ID is found
    }
}
