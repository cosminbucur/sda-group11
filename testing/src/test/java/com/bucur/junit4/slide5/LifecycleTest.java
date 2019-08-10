package com.bucur.junit4.slide5;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class LifecycleTest {

    //execute only once, in the starting
    @BeforeClass
    public static void beforeClass() {
        System.out.println("run before the first test method");
    }

    //execute only once, in the end
    @AfterClass
    public static void afterClass() {
        System.out.println("run after the last test method");
    }

    //execute for each test, before executing test
    @Before
    public void before() {
        System.out.println("run before each test");
    }

    //execute for each test, after executing test
    @After
    public void after() {
        System.out.println("run after each test");
    }

    //test case 1
    @Test
    public void testCase1() {
        System.out.println("in test case 1");
    }

    //test case 2
    @Test
    public void testCase2() {
        System.out.println("in test case 2");
    }

    @Ignore
    @Test
    public void ignoredTest() {
        System.out.println("you should not see this");
    }
}
