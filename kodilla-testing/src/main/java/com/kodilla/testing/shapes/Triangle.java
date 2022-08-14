package com.kodilla.testing.shapes;

public class Triangle implements Shape{
    private double sideLength;
    private double height;

    public Triangle(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    @Override
    public double getField() {
        return (sideLength * height)/2;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
