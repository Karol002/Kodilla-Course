package com.kodilla.exeception.test;
import java.io.IOException;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        try {
            if (b == 0)  throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("Do not divide by zero... The result is wrong " + e);
        } finally {
            return a / b;
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(1, 0);

        System.out.println(result);
    }
}
