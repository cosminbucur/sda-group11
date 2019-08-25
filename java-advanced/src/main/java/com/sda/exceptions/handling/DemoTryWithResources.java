package com.sda.exceptions.handling;

import java.util.Scanner;

public class DemoTryWithResources {

    public static void main(String[] args) {
        tryCatchFinally();

        tryWithResources();
    }

    private static void tryCatchFinally() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("error with scanner");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println(scanner.next()); // scanner.closed = false
    }

    private static void tryWithResources() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Wow, you typed: \"" + scanner.next() + "\". You so smart...");
        } catch (Exception e) {
            // handle exception
        }
        // no need to close scanner in finally
    }
}
