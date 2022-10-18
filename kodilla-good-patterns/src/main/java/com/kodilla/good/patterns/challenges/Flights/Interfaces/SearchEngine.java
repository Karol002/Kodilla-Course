package com.kodilla.good.patterns.challenges.Flights.Interfaces;

import java.util.List;

public interface SearchEngine {
    List searchFrom(String base);
    List searchTo(String destination);
    List search(String base, String destination);
    List advancedSearch(String base, String destination);
}
