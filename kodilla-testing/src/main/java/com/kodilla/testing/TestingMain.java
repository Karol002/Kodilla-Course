package com.kodilla.testing;

import com.kodilla.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        Calculator calc = new Calculator(5, 3);
        if (calc.addAtoB() == 8) {
            System.out.println("The add function works fine");
        } else {
            System.out.println("The add function does not work fine");
        }

        if (calc.substractBfromA() == 2) {
            System.out.println("The substract function works fine");
        } else {
            System.out.println("The substract function does not work fine");
        }
    }
}
