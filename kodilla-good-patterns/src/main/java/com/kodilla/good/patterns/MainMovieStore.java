package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.stream.Collectors;


public class MainMovieStore {

    public static void main(String [] args) {


        System.out.println(MovieStore.getMovies().entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .map(e -> "! " + e)
                .collect(Collectors.joining())
                .substring(2));
    }
}
