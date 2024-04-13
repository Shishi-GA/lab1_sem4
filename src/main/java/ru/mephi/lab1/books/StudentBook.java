package ru.mephi.lab1.books;

public abstract class StudentBook implements Book {

    protected String ISBN;
    protected String name;
    protected String author;

    public StudentBook(String ISBN, String name, String author) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
    }

}
