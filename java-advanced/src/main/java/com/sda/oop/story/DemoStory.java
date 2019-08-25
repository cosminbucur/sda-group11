package com.sda.oop.story;

import com.sda.oop.story.andreea.Andreea;
import com.sda.oop.story.andreea.Pony;
import com.sda.oop.story.stefania.Stefania;
import com.sda.oop.story.women.FinancialSecurity;
import com.sda.oop.story.women.Love;

public class DemoStory {

    public static void main(String[] args) {
        System.out.println("let me prove the concepts of object oriented programming using two misogynistic stories.");
        storyOfAndreea();
        storyOfStefania();
    }

    private static void storyOfAndreea() {
        System.out.println("this is the story of andreea...");
        Love love = new Love();
        FinancialSecurity financialSecurity = new FinancialSecurity();
        Andreea andreea = new Andreea(love, financialSecurity);

        // common skills
        andreea.feel();
        andreea.dream();
        andreea.relax();

        andreea.haveFun();
        andreea.getTanned();
        andreea.getNailsDone();

        // new skills
        andreea.speakEnglish();
        andreea.speakSpanish();

        // HAS-A relationship
        Pony mockPony = null;
        andreea.pleaseGiveMeAPony(mockPony);

        Pony realPony = new Pony("Dixie");
        andreea.pleaseGiveMeAPony(realPony);
        andreea.feedPony();
    }

    private static void storyOfStefania() {
        System.out.println("meanwhile, stefania...");
        Love love = new Love();
        FinancialSecurity financialSecurity = new FinancialSecurity();
        Stefania stefania = new Stefania(love, financialSecurity);

        // common skills
        stefania.feel();
        stefania.dream();
        stefania.relax();

        // new skills
    }
}
