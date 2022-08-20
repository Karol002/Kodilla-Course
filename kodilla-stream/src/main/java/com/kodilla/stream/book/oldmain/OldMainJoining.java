/*
package com.kodilla.stream.book.oldmain;

public class OldMainJoining {
    BookDirectory theBookDirectory = new BookDirectory();
    String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
            .filter(book -> book.getYearOfPublication() > 2005)
            .map(Book::toString)
            .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

         System.out.println(theResultStringOfBooks);
}
*/
