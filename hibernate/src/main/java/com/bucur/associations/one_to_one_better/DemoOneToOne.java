package com.bucur.associations.one_to_one_better;

import java.time.LocalDate;

public class DemoOneToOne {

    public static void main(String[] args) {
        // create both objects
        Employee employee = new Employee();
        employee.setFirstName("jon");
        employee.setLastName("snow");
        employee.setEmail("jonsnow@gmail.com");

        Account account = new Account();
        account.setAccountNumber("12");
        account.setEmploymentDate(LocalDate.now());

        account.setEmployee(employee);

        employee.setAccount(account);

        // persist one
        AccountDao accountDao = new AccountDao();
        accountDao.create(account);
    }
}
