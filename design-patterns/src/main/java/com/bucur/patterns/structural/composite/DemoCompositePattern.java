package com.bucur.patterns.structural.composite;

import com.bucur.patterns.structural.composite.editor.ImageEditor;
import com.bucur.patterns.structural.composite.shapes.Circle;
import com.bucur.patterns.structural.composite.shapes.CompoundShape;
import com.bucur.patterns.structural.composite.shapes.Dot;

import java.awt.*;

public class DemoCompositePattern {

    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 2, Color.BLUE),

                new CompoundShape(
                        new Circle(10, 10, 2, Color.BLUE),
                        new Dot(160, 160, Color.RED)
                )
        );
    }
}
