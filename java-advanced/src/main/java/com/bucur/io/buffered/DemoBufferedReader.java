package com.bucur.io.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoBufferedReader {

    public static void main(String[] args) {
        // read using buffered reader
//        try {
//            String path = "C:\\dev\\sda\\group11\\java-advanced\\src\\main\\resources\\people.txt";
//            readUsingBufferedReader(path);
//        } catch (IOException e) {
//            System.out.println("error reading file");
//        }

        List<String> names = new ArrayList<>();
        names.add("vlad");
        names.add("ana");
        names.add("cristi");
        String path = "C:\\dev\\sda\\group11\\java-advanced\\src\\main\\resources\\newPeople.txt";
        // write using buffered reader
        writeUsingBufferedReader(names, path);

        try {
            readUsingBufferedReader(path);
        } catch (IOException e) {
            System.out.println("error reading file");
        }
    }

    private static void readUsingBufferedReader(String path) throws IOException {
        // create buffered reader
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String firstLine;

        // read from file
        while ((firstLine = br.readLine()) != null) {

            // print content
            System.out.println(firstLine);
        }
    }

    // write 3 names in a file
    private static void writeUsingBufferedReader(List<String> anyList, String path) {
        // put names in a list

        // de unde iau numele?
        // tastatura | definire manuala

        // in ce fisier scriu?
        File file = new File(path);

        // cum scriu?

        // try with resources
        // try (resources that must be closed) {
        //      code that might fail
        // } catch (exception type) {
        //      handle exception
        // }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (String item : anyList) {
                bw.write(item + "\n");
            }
        } catch (IOException e) {
            System.out.println("error writing file");
        }

        try {
            // code that might fail
        } catch (Exception e) {
            System.out.println("only if exception is caught");
        } finally {
            // close resources
            System.out.println("this happens no matter what");
        }
    }
}
