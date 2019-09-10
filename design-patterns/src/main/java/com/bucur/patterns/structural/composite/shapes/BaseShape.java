package com.bucur.patterns.structural.composite.shapes;

import java.awt.*;

public class BaseShape implements MyShape {

    public int x;
    public int y;
    private boolean selected;
    private Color color;

    public BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void select() {
        this.selected = true;
    }

    @Override
    public void deselect() {
        this.selected = false;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void paint(Graphics graphics) {

    }
}
