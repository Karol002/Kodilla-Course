package com.kodilla.testing.shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapes = new ArrayList<>();

    public boolean addFigure(Shape shape) {
        return false;
    }

    public boolean removeFigure(Shape shape) {
        return false;
    }

    public Shape getFigure(int n) {
        return null;
    }

    public String showFigures() {
        return "Shape";
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
