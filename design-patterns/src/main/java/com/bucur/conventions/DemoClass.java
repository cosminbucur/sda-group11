package com.bucur.conventions;

import java.util.Objects;

/*
This class performs this operation
 */
public class DemoClass {        // class definition

    // static variables
    private static final String STATIC_VARIABLE = "30";

    // instance variables
    private int instanceVariable;

    // constructor
    public DemoClass(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    // methods
    public void doPublicWork() {
        privateMethod();
    }

    // private methods
    private void privateMethod() {

    }

    // getters and setters
    public int getInstanceVariable() {
        return instanceVariable;
    }

    public void setInstanceVariable(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    // equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoClass demoClass = (DemoClass) o;
        return instanceVariable == demoClass.instanceVariable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceVariable);
    }

    // to string
    @Override
    public String toString() {
        return "DemoClass{" +
                "instanceVariable=" + instanceVariable +
                '}';
    }
}
