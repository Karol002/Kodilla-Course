/*
package com.kodilla.stream.person;

public class OldName {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
        People.getList().stream()                         // [1]
                .forEach(System.out::println);                 // [2]

        System.out.println("--------------------------------------------------------------");


        People.getList().stream()
                .map(s -> s.toUpperCase())                      // [1]
                .forEach(System.out::println);                  // [2]

        System.out.println("--------------------------------------------------------------");


        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        System.out.println("--------------------------------------------------------------");

        People.getList().stream()
                .map(String::toUpperCase)                             // [1]
                .filter(s -> s.length() > 11)                         // [2]
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
                .forEach(System.out::println);                        // [5]
    }
}
*/
