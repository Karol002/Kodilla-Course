package com.kodilla.testing.collection;

import java.util.LinkedList;
import java.util.List;

public class OddNumbersExterminator {
    private List<Integer> evenNumbers;

    public OddNumbersExterminator() {
        evenNumbers = new LinkedList<>();
    }

    public  List<Integer> exterminate(List<Integer> numbers) {
        for (Integer theValue : numbers) {
            if (theValue % 2 == 0) {
                evenNumbers.add(theValue);
            }
        }
        return evenNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }
}
