package com.bucur.associations.one_to_mani_uni_join;

import java.util.ArrayList;
import java.util.List;

public class DemoOneToManyUnidirectionalJoin {

    public static void main(String[] args) {
        // create 2 sons
        Son son1 = new Son();
        son1.setTitle("son1");

        Son son2 = new Son();
        son2.setTitle("son2");

        // create a father
        Father father = new Father();
        father.setName("father");
        father.setEmail("father@gmail.com");
        father.setCountry("fatherland");

        // persist father

        // 1. add children to parent
        List<Son> sons = new ArrayList<>();
        sons.add(son1);
        sons.add(son2);
        father.setSons(sons);

        FatherDao fatherDao = new FatherDao();
        fatherDao.create(father);
    }
}
