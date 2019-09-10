package com.bucur.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DemoNio {

    public static void main(String[] args) {
        // Path - interface for handling path objects
        // Paths - transform a string to a path object
        Path path = Paths.get("C:\\dev\\sda\\group11\\java-advanced\\src\\main\\resources\\people.txt");

        List<String> names = new ArrayList<>();
        names.add("vlad");
        names.add("ana");
        names.add("cristi");

        // Files - utility class for file operations
        try {
            Files.write(path, names);
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
