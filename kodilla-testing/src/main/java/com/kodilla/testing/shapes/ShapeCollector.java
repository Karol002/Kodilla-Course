package com.kodilla.testing.shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n) {
        if (shapes.isEmpty()) {
            return null;
        } else {
            return shapes.get(n);
        }
    }

    public String showFigures() {
        String allNames = "";
        for (Shape theShape : shapes) {
            allNames += theShape.getShapeName();
        }
        return allNames;
    }

    public int getFigureQuantity() {
        return shapes.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeCollector that)) return false;

        return shapes.equals(that.shapes);
    }

    @Override
    public int hashCode() {
        return shapes.hashCode();
    }
}
