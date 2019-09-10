package com.bucur.functional.streams;

import java.util.stream.Stream;

public class DemoPeek {

    public static void main(String[] args) {
        Stream<User> userStream = Stream.of(new User("Alice"));
        userStream.peek(u -> u.setUserName(u.getUserName().toLowerCase()))
//                .forEach(System.out::println)
                .forEach(u -> System.out.println(u.getUserName()));
    }
}

