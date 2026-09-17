package com.customeranalytics.service;
import com.customeranalytics.model.Customer;
import java.util.ArrayList;

public class CustomerService {
    private ArrayList<Customer> customers = new ArrayList<>();
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void viewCustomers() {

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println("-------------------------");
            customer.displayCustomer();
        }
    }

    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}