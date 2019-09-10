package com.bucur.oop.story.andreea;

import com.bucur.oop.story.skills.Developer;
import com.bucur.oop.story.skills.Polygot;
import com.bucur.oop.story.women.FinancialSecurity;
import com.bucur.oop.story.women.Love;
import com.bucur.oop.story.women.Woman;

// IS-A relationship
// andreea can only be a woman
// andreea can play multiple roles
public class Andreea extends Woman implements Polygot, Developer {

    // HAS-A relationship
    // aggregation - I know it's hard but andreea can survive without it
    private Pony pony;

    // because andreea is a woman, she has a woman's needs
    public Andreea(Love love, FinancialSecurity financialSecurity) {
        super(love, financialSecurity);
        System.out.println("You know what? I would also need a pony!");
    }

    public void haveFun() {
        System.out.println("Having fun: TGIF (Thank God It's Friday!)");
    }

    public void getTanned() {
        System.out.println("Getting tanned: ouch! that burns");
    }

    public void getNailsDone() {
        System.out.println("Getting nails done: oops. I broke a nail :(");
    }

    // this is a request (query - return)
    public Pony pleaseGiveMeAPony(Pony pony) {
        System.out.println("Please give me a pony! " +
                "I only want what I want when I want it. " +
                "That's not immature at all!");
        if (pony != null) {
            this.pony = pony;
            System.out.println("Yey! I have my " + pony + ". Now I can die happy!");
        } else {
            System.out.println("You promised!!! :((((");
        }
        return this.pony;
    }

    // this is an order (command - void)
    public void feedPony() {
        System.out.println("Here's an apple Mr. " + pony.getName() + "! :*");
        this.pony.eat();
    }

    // each woman behaves differently
    @Override
    public void feel() {
        System.out.println("Feeling: I feel tired");
    }

    @Override
    public void dream() {
        System.out.println("Dreaming: Should I pick this dress or that dress? ... I know! I pick both :p");
    }

    @Override
    public void relax() {
        System.out.println("Relaxing: Programming makes me sleepy. I need a break.");
    }

    // each polyglot speaks differently
    @Override
    public void speakEnglish() {
        System.out.println("Speaking english: The rain is on the plane in Spain.");
    }

    @Override
    public void speakSpanish() {
        System.out.println("Speaking spanish: Hola, Yo me llamo Mariola");
    }

    @Override
    public void develop() {
        System.out.println("Developing: Writing code like a baws!");
    }
}
