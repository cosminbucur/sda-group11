package com.sda.optional.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    private List<Person> people = new ArrayList<>();

    public Database() {
        this.people.add(new Person("alex"));
        this.people.add(new Person("ana"));
    }

    public Optional<Person> findPersonByName(String name) {
        return this.people.stream()
                .filter(person -> person.getName().equals(name))
                .findAny();
    }
}
