package com.bucur.associations.one_to_many_bi;

public class DemoOneToManyBidirectional {

    public static void main(String[] args) {
        // create 2 children
        Child child1 = new Child();
        child1.setTitle("child1");

        Child child2 = new Child();
        child2.setTitle("child2");

        // create a parent
        Parent parent = new Parent();
        parent.setName("parent");
        parent.setEmail("parent@gmail.com");
        parent.setCountry("parentland");

        // add children to parent
        parent.addChild(child1);
        parent.addChild(child2);

        // persist parent
        ParentDao parentDao = new ParentDao();
        parentDao.create(parent);
    }
}
