package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("TDD: JUnit and Mockito Test Suite \uD83D\uDE31")
@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    //...
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    // ...

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests begin" + "\n");
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

    @Nested
    @DisplayName("Tests for ListBookWithCondition")
    class ListBookWithCondition {

        @DisplayName("Tests for Correct List")
        @Test
        void testListBooksWithConditionsReturnList() {

            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @DisplayName("Tests for to Big List")
        @Test
        void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<Book>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(0, theListOfBooks40.size());
        }

        @DisplayName("Tests for to Short List")
        @Test
        void testListBooksWithConditionFragmentShorterThan3() {

            // Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            // When
            List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

            // Then
            assertEquals(0, theListOfBooks10.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }

    }

    @Nested
    @DisplayName("Tests for ListBooksInHandsOf")
    class ListBookInHandsOf {

        @Test
        void testListBooksInHandsOf() {

            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Karol", "W1", "123456789");
            LibraryUser libraryUser1 = new LibraryUser("Karol", "W2", "123456789");
            LibraryUser libraryUser5 = new LibraryUser("Karol", "W5", "123456789");

            List<Book> resultListOf0Books = new ArrayList<Book>();
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf0Books);

            List<Book> resultListOf1Books = generateListOfNBooks(1);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultListOf1Books);

            List<Book> resultListOf5Books = generateListOfNBooks(5);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5)).thenReturn(resultListOf5Books);

            // When
            List<Book> theListOf0Books = bookLibrary.listBookInHandsOf(libraryUser);
            List<Book> theListOf1Books = bookLibrary.listBookInHandsOf(libraryUser1);
            List<Book> theListOf5Books = bookLibrary.listBookInHandsOf(libraryUser5);

            // Then
            assertEquals(0, theListOf0Books.size());
            assertEquals(1, theListOf1Books.size());
            assertEquals(5, theListOf5Books.size());
        }
    }
}
