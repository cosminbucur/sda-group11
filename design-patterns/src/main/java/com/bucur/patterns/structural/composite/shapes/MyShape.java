package com.bucur.patterns.structural.composite.shapes;

import java.awt.*;

public interface MyShape {

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void move(int x, int y);

    void select();

    void deselect();

    boolean isSelected();

    void paint(Graphics graphics);
}
