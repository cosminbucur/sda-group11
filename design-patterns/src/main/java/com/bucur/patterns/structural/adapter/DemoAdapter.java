package com.bucur.patterns.structural.adapter;

import com.bucur.patterns.structural.adapter.round.RoundHole;
import com.bucur.patterns.structural.adapter.round.RoundPeg;
import com.bucur.patterns.structural.adapter.square.SquarePeg;

public class DemoAdapter {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);

        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) {
            System.out.println("round peg fits hole ");
        }

        SquarePeg smallSquarePeg = new SquarePeg(2);
//        hole.fits(smallSquarePeg);  // wont compile

        SquarePegAdapter smallSquarePegAdapter = new SquarePegAdapter(smallSquarePeg);

        if (hole.fits(smallSquarePegAdapter)) {
            System.out.println("square peg with width" + smallSquarePeg.getWidth()
                    + "fits round hole with radius " + hole.getRadius());
        }

        SquarePeg largeSquarePeg = new SquarePeg(10);
        SquarePegAdapter largeSquarePegAdapter = new SquarePegAdapter(largeSquarePeg);

        if (hole.fits(largeSquarePegAdapter)) {
            System.out.println("square peg with width" + largeSquarePeg.getWidth()
                    + "fits round hole with radius " + hole.getRadius());
        }

    }
}
