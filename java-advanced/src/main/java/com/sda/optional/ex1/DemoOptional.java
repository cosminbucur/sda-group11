package com.sda.optional.ex1;

import java.util.Optional;

public class DemoOptional {

    public static void main(String[] args) {
        // create an optional
//        Optional<String> optionalString = Optional.of("hello");
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("default value");
        System.out.println(result);

        doSomething(optionalString);

        String valueFromOptional = optionalString.get(); // hello

        optionalString
                .orElseThrow(() -> new RuntimeException("my string is missing"));

        Database database = new Database();
        Optional<Person> optionalPerson = database.findPersonByName("cristi");
        database.findPersonByName("cristi")
                .orElseThrow(() -> new RuntimeException("person not found"));
    }

    /*
     * Optional
     *   String value;
     *
     *   get() {
     *   return this.value;
     *   }
     * */
    private static void doSomething(Optional<String> stringOptional) {
        if (stringOptional.isPresent()) {
            String stringFromOptional = stringOptional.get();
            System.out.println(stringFromOptional);
        }
    }
}
