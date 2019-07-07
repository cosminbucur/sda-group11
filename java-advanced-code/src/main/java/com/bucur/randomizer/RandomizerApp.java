package com.bucur.randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizerApp {

    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        dispatch(option);
    }

    private static void dispatch(int option) {
        while (option != 0) {
            switch (option) {
                case 1:
                    addPersons();
                    break;
                default:
                    System.out.println("choose one of the options");
            }
        }
    }

    private static void addPersons() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Who's next? (press 'n' if all are ready");

            String name = scanner.nextLine();

            int min = 1;
            int max = 5;
            int randomDifficulty = getRandomNumberInRange(min, max);
            Person person = new Person(name, randomDifficulty);
            person.setPresent(true);

            people.add(person);
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1 + min);
    }

    private static void displayMenu() {
        System.out.println("Menu -----------------");
        System.out.println("1. add persons");
        System.out.println("2. select next person");
        System.out.println("0. exit \n");
        System.out.println("Please choose an option:");
    }
}
