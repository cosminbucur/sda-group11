package com.bucur.patterns.structural.composite.editor;

import com.bucur.patterns.structural.composite.shapes.CompoundShape;
import com.bucur.patterns.structural.composite.shapes.MyShape;

import java.awt.*;

public class ImageEditor {

    private EditorCanvas canvas;
    private CompoundShape allShapes = new CompoundShape();

    public ImageEditor() {
        canvas = new EditorCanvas();
    }

    public void loadShapes(MyShape... myShape) {

    }

    private class EditorCanvas extends Canvas {

    }

}
