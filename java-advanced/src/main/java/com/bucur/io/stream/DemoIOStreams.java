package com.bucur.io.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DemoIOStreams {

    public static void main(String[] args) {
        String path = "C:\\dev\\sda\\group11\\java-advanced\\src\\main\\resources\\fileForStream.txt";

        Person person = new Person();
        person.setFirstName("alex");
        person.setLastName("vasile");

        writeUsingFileOutputStream(path, person);
    }

    // FileOutputStream - create a stream from a file
    // ObjectOutputStream - used to write objects
    private static void writeUsingFileOutputStream(String path, Person person) {
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(person);
        } catch (Exception e) {
            System.out.println("error writing stream");
        }
    }

    // TODO: finish this implementation
    private static Person readUsingFileOutputStream(String path) {
        // de unde?

        // unde il pun?
        Person person = new Person();
        return person;
    }
}