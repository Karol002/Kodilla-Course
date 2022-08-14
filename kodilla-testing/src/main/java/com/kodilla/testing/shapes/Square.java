package com.kodilla.testing.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getField() {
        return sideLength * sideLength;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;

        return Double.compare(square.getSideLength(), getSideLength()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getSideLength());
        return (int) (temp ^ (temp >>> 32));
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}
