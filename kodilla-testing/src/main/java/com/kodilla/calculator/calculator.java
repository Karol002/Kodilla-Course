package com.kodilla.calculator;

public class Calculator {
    int a;
    int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addAtoB() {
        return a + b;
    }

    public int substractBfromA() {
        return a - b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
