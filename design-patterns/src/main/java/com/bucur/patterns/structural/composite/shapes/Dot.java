package com.bucur.patterns.structural.composite.shapes;

import java.awt.*;

public class Dot extends BaseShape {


    private static final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }
}
