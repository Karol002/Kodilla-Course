package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@DisplayName("Test of the list eliminating unapproachable numbers")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("Check that the full list is maintained")

    @Test
    void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();

        //When
        List<Integer> allNumbers = new LinkedList<>();
        for (int i=1 ; i<=10; i++) {
            allNumbers.add(i);
        }

        List<Integer> expection = Arrays.asList(2,4,6,8,10);
        exterminator.exterminate(allNumbers);

        //Then
        Assertions.assertEquals(exterminator.getEvenNumbers(),expection);
    }
}
