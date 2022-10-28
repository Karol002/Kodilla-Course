package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBookToLibrary(Book book) {
        books.add(book);
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();

        for (Book theBook : books) {
            clonedLibrary.addBookToLibrary(theBook);
        }

        return clonedLibrary;
    }

    @Override
    public String toString() {
        StringBuilder libraryToText = new StringBuilder("Library " + name + "\n");
                for (Book theBook : books) {
                    libraryToText.append("      ").append(theBook).append("\n");
                }
        return libraryToText.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;

        if (!getName().equals(library.getName())) return false;
        return getBooks().equals(library.getBooks());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getBooks().hashCode();
        return result;
    }
}