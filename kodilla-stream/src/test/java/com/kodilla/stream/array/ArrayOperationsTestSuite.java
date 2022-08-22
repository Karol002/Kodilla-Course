package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("IntStream Test suite \uD83D\uDE31")
public class ArrayOperationsTestSuite {

    @DisplayName("Test for calculating average")
    @Test
    void testGetAverage() {

        //Given
        double sum = 0;
        int numbers[] = new int[20];
        for (int i=0; i<20; i++) {
            numbers[i] = i;
            sum += numbers[i];
        }

        //When
        double result = getAverage(numbers);
        sum /= numbers.length;

        //Then
        assertEquals(sum,result);
    }
}
