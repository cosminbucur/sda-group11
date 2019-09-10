package com.bucur.patterns.structural.adapter;

import com.bucur.patterns.structural.adapter.round.RoundPeg;
import com.bucur.patterns.structural.adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(squarePeg.getWidth() / 2, 2) * 2);
    }
}
