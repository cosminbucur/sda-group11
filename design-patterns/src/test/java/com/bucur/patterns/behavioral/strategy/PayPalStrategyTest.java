package com.bucur.patterns.behavioral.strategy;

import org.junit.Test;

public class PayPalStrategyTest {


    @Test
    public void givenOrder_whenPayUsingPayPal_thenOk() {
        // 1 paypal
        // 2 credit card

        String input = "1";

        PayByPayPal payStrategy = new PayByPayPal();

        Order order = new Order();
        order.processOrder(payStrategy);
    }
}