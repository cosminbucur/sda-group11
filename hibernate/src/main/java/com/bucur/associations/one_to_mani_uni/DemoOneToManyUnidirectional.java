package com.bucur.associations.one_to_mani_uni;

public class DemoOneToManyUnidirectional {

    public static void main(String[] args) {
        // create 2 daughters
        Daughter daughter1 = new Daughter();
        daughter1.setTitle("daughter1");

        Daughter daughter2 = new Daughter();
        daughter2.setTitle("daughter2");

        // create a mother
        Mother mother = new Mother();
        mother.setName("mother");
        mother.setEmail("mother@gmail.com");
        mother.setCountry("motherland");

        // persist mother

        // 1. add children to parent
//        List<Daughter> daughters = new ArrayList<>();
//        daughters.add(daughter1);
//        daughters.add(daughter2);
//        mother.setDaughters(daughters);

        // 2. add children to parent
        mother.getDaughters().add(daughter1);
        mother.getDaughters().add(daughter2);


        MotherDao motherDao = new MotherDao();
        motherDao.create(mother);
    }
}
