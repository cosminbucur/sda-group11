package com.bucur.audit.history;

import com.bucur.audit.customer.Customer;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import java.time.LocalDateTime;

public class CustomerHistoryListener {

    private CustomerHistoryRepository customerHistoryRepository;

    public CustomerHistoryListener() {
        this.customerHistoryRepository = new CustomerHistoryRepository();
    }

    @PostPersist
    public void postPersist(Customer customer) {
        // after customer is persisted in customer table
        // insert entry in history
        perform(customer, Action.INSERTED);
    }

    @PostUpdate
    public void postUpdated(Customer customer) {
        perform(customer, Action.UPDATED);
    }

    @PostRemove
    public void postRemove(Customer customer) {
        perform(customer, Action.DELETED);
    }

    public void perform(Customer customer, Action action) {
        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setAction(action);
        customerHistory.setCreationDate(LocalDateTime.now());
        customerHistory.setCustomerId(customer.getId());
        customerHistory.setModifiedBy("current user");

        customerHistoryRepository.create(customerHistory);
    }
}
