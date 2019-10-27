package com.bucur.audit;

import com.bucur.audit.customer.Customer;
import com.bucur.audit.customer.CustomerRepository;

public class DemoAudit {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setFirstName("jon");
        customer.setLastName("snow");
        // transient

        CustomerRepository customerRepository = new CustomerRepository();

        customerRepository.create(customer);
        // persisted

        Customer newCustomer = customerRepository.findById(1L);
        newCustomer.setFirstName("alex");
        newCustomer.setLastName("vasile");
        // detached

        customerRepository.update(newCustomer);

        Customer updatedCustomer = customerRepository.findById(1L);
//        customerRepository.delete(updatedCustomer);
    }
}
