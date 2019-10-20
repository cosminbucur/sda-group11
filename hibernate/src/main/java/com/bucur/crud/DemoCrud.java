package com.bucur.crud;

public class DemoCrud {

    public static void main(String[] args) {
//        testPersonDao();
        testPersonAdvancedDao();
    }

    private static void testPersonAdvancedDao() {
        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        Person newPerson = new Person();
        newPerson.setFirstName("alex");
        newPerson.setLastName("vasile");
        newPerson.setEmail("alexvasile@gmail.com");
        newPerson.setCountry("romania");

        PersonAdvancedDao dao = new PersonAdvancedDao();
        dao.create(person);
        dao.create(newPerson);

        dao.findAll();
        Person toBeDeleted = dao.findById(1L);
        dao.delete(toBeDeleted);
    }

    private static void testPersonDao() {
        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        PersonDao personDao = new PersonDao();
        personDao.create(person);

        Person newPerson = personDao.findById(1L);

        newPerson.setFirstName("alex");
        newPerson.setLastName("vasile");
        newPerson.setEmail("alexvasile@gmail.com");
        newPerson.setCountry("romania");

        personDao.update(newPerson);

        Person updatedPerson = personDao.findById(1L);
        personDao.delete(updatedPerson);
    }
}
