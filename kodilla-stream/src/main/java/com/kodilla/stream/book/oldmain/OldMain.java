/*
package com.kodilla.stream.book;

import java.util.List;
import java.util.stream.Collectors;

public class OldMain {
    BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
            .forEach(System.out::println);

        System.out.println("--------------------------------------------------------------");

    BookDirectory theBookDirectory1 = new BookDirectory();
    List<Book> theResultListOfBooks = theBookDirectory1.getList().stream()   // [1]
            .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
            .collect(Collectors.toList());                                       // [3]

        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
        theResultListOfBooks.stream()                                           // [5]
                .forEach(System.out::println);
}
*/
