package com.bucur.audit.history;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_history")
public class CustomerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long customerId;

    @Enumerated(EnumType.STRING)
    private Action action;

    private LocalDateTime creationDate;
    private String modifiedBy;

    public CustomerHistory() {
    }

    public CustomerHistory(Long customerId, Action action, LocalDateTime creationDate, String modifiedBy) {
        this.customerId = customerId;
        this.action = action;
        this.creationDate = creationDate;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "CustomerHistory{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", action=" + action +
                ", creationDate=" + creationDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
