package com.bucur.solid.single_responsibility.after;

import com.bucur.solid.single_responsibility.before.Employee;

public class DemoSingleResponsibility {

    public static void main(String[] args) {
        Employee employee = new Employee();
        HrPromotions hrPromotions = new HrPromotions();
        TaxCalculation taxCalculation = new TaxCalculation();

        hrPromotions.isPromotionDueThisYear();
        taxCalculation.calculateTaxForCurrentYear();
    }
}
