package com.kodilla.testing.shapes;

import static java.lang.Math.PI;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getField() {
        return (radius * radius) * PI;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
