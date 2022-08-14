package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("TDD: Mokito Test Suite \uD83D\uDE31")
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    static Map<String, Double> temperaturesMap = new HashMap<>();
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begin" + "\n");
        temperaturesMap.put("Rzeszow", 10.0);
        temperaturesMap.put("Krakow", 20.0);
        temperaturesMap.put("Wroclaw", 30.0);
        temperaturesMap.put("Warszawa", 15.0);
        temperaturesMap.put("Gdansk", 25.0);
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter + "\n");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test finished");
    }

    @DisplayName("Tests calculating Median")
    @Test
    void testCalculateMedianWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherAverage = new WeatherForecast(temperaturesMock);

        //When
        double mapMedianValue = weatherAverage.calculateMedian();

        //Then
        Assertions.assertEquals(20, mapMedianValue);
    }

    @DisplayName("Tests for calculate average")
    @Test
    void testCalculateAverageWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherAverage = new WeatherForecast(temperaturesMock);

        //When
        double temperaturesAverage = weatherAverage.calculateAverage();

        //Then
        Assertions.assertEquals(20, temperaturesAverage);
    }

    @DisplayName("Tests checking Map size")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Tests calculating Median for even List")
    @Test
    void testCalculateMedianEvenListWithMock() {
        //Given
        temperaturesMap.remove("Gdansk");
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherAverage = new WeatherForecast(temperaturesMock);

        //When
        double mapMedianValue = weatherAverage.calculateMedian();

        //Then
        Assertions.assertEquals(17.5, mapMedianValue);
        temperaturesMap.put("Gdansk", 25.0);
    }
}
