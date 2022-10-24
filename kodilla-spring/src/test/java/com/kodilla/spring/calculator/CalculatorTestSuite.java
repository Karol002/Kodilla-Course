package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testForAdd() {
        //Given
        //When
        double result = calculator.add(3.0, 3.0);
        //Then
        assertEquals(6.0, result);
    }

    @Test
    public void testForSub() {
        //Given
        //When
        double result = calculator.sub(2.0, 2.0);
        //Then
        assertEquals(0.0, result);
    }

    @Test
    public void testForMul() {
        //Given
        //When
        double result = calculator.mul(3.0, 3.0);
        //Then
        assertEquals(9.0, result);
    }

    @Test
    public void testForDiv() {
        //Given
        //When
        double result = calculator.div(2.0, 2.0);
        //Then
        assertEquals(1.0, result);
    }
}
