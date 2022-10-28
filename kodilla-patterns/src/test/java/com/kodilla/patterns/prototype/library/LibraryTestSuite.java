package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("myLibrary");
        for (int i=0; i<5; i++) {
            library.addBookToLibrary(new Book
                    ("Title" + (i+1), "Author" + (i+1), LocalDate.now().minusYears(i)));
        }

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("myClonedLibrary");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("myDeepClonedLibrary");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library.addBookToLibrary(new Book
                ("Harry Potter", "J.K. Rowling", LocalDate.of(1997,4,10)));

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(6, library.getBooks().size());
        assertEquals(6, clonedLibrary.getBooks().size());
        assertNotEquals(6, deepClonedLibrary.getBooks().size());
    }
}
