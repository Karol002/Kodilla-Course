package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public double calculateAverage() {
        double average = 0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            average += temperature.getValue();
        }

        int size = temperatures.getTemperatures().size();
        return average / (double) size;
    }

    public double calculateMedian() {
        List<Double> median = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            median.add(temperature.getValue());
        }

        Collections.sort(median);
        double finalMedian = 0;
        if ((median.size() % 2) != 0) {
            finalMedian = median.get((median.size() - 1) / 2);
        } else {
            finalMedian = (median.get((median.size() / 2) - 1) + median.get(median.size() / 2)) / 2;
        }

        return  finalMedian;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
}
