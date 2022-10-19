package com.kodilla.good.patterns.challenges.flights.interfaces;

import java.util.List;

public interface SearchEngine {
    List searchCity(String base);


    List advancedSearch(String base, String middle, String destination);
}
