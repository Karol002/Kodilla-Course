package com.kodilla.stream.world;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BigDecimal and flatMap test suite \uD83D\uDE31")
public class WorldTestSuite {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begin" + "\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test finished");
    }

    @DisplayName("Test for calculation of the sum of people in the world")
    @Test
    void testForCalculationSumOfPeople() {
        //Given
        Country poland = new Country(new BigDecimal("40000000"));
        Country spain = new Country(new BigDecimal("80000000"));
        Country england = new Country(new BigDecimal("70000000"));

        Country china = new Country(new BigDecimal("1000000000"));
        Country japan = new Country(new BigDecimal("200000000"));
        Country india = new Country(new BigDecimal("1300000000"));

        Country usa = new Country(new BigDecimal("300000000"));
        Country mexico = new Country(new BigDecimal("200000000"));
        Country canada = new Country(new BigDecimal("100000000"));

        Continent europa = new Continent();
        europa.addCountry(poland);
        europa.addCountry(spain);
        europa.addCountry(england);

        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(india);

        Continent southAmerica = new Continent();
        southAmerica.addCountry(usa);
        southAmerica.addCountry(mexico);
        southAmerica.addCountry(canada);

        World world = new World();
        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(southAmerica);

        List<Country> countryList = new ArrayList<>();
        countryList.add(poland); countryList.add(england); countryList.add(spain);
        countryList.add(china);  countryList.add(japan);   countryList.add(india);
        countryList.add(usa);    countryList.add(canada);  countryList.add(mexico);

        //When
        BigDecimal expectPeopleQuantity = BigDecimal.ZERO;
        for (Country thCountry : countryList) {
            expectPeopleQuantity = expectPeopleQuantity.add(thCountry.getPeopleQuantity());
        }

        BigDecimal resultPeopleQuantity = world.getWorldPeopleQuantity();

        //Then
        assertEquals(expectPeopleQuantity,resultPeopleQuantity);
    }
}
