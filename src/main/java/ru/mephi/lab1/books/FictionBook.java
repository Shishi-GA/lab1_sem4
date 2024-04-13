package ru.mephi.lab1.books;

public abstract class FictionBook implements Book {

    protected String ISBN;
    protected String name;
    protected String author;

    public FictionBook(String ISBN, String name, String author) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

}
