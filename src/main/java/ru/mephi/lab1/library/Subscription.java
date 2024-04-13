package ru.mephi.lab1.library;

import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.books.Book;
import java.util.HashSet;
import java.util.Set;

public class Subscription {

    private LibraryUser owner;
    private Set<Book> rentBooks;

    public Subscription(LibraryUser owner) {
        this.owner = owner;
        this.rentBooks = new HashSet<>();
    }

    public void addBook(Book book) {
        rentBooks.add(book);
    }

    public Set<Book> getRentBooks() {
        return rentBooks;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "rentBooks=" + rentBooks +
                '}';
    }

}
