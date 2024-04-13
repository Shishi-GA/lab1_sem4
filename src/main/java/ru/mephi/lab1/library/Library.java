package ru.mephi.lab1.library;

import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.books.Book;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<LibraryUser, Subscription> subscriptions;
    private final Map<Book, Integer> bookNumber;

    public Library() {
        this.subscriptions = new HashMap<>();
        this.bookNumber = new HashMap<>();
    }

    public void addSubscription(LibraryUser libraryUser, Subscription subscription) {
        subscriptions.put(libraryUser, subscription);
    }

    public void rentBook(Book book, LibraryUser libraryUser) {
        int booksNumber = this.bookNumber.get(book);
        if (booksNumber >= 1) {
            Subscription subscription = this.subscriptions.get(libraryUser);
            subscription.addBook(book);
            this.bookNumber.put(book, booksNumber - 1);
        }
    }

    public void addBook(Book book, int number) {
        bookNumber.put(book, number);
    }

    @Override
    public String toString() {
        return "Library{" +
                "subscriptions=" + subscriptions +
                ", bookNumber=" + bookNumber +
                '}';
    }

}
