package com.bucur.patterns.structural.composite.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompoundShape extends BaseShape {

    List<MyShape> children = new ArrayList<>();

    public CompoundShape(MyShape... components) {
        super(0, 0, Color.BLACK);
    }

    public void add(MyShape component) {
        children.add(component);
    }

    public void paint(Graphics graphics) {
        // TODO: paint all graphics
    }
}
