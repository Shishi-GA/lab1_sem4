package ru.mephi.lab1.books;

public class RussianStudentBook extends StudentBook {

    private final String prefix;

    public RussianStudentBook(String ISBN, String name, String author, String prefix) {
        super(ISBN, name, author);
        this.prefix = prefix;
    }

    @Override
    public String getName() {
        return prefix + " " + "\"" + super.name + "\", " + author + ", ISBN: " + ISBN;
    }

    @Override
    public String toString() {
        return "RussianStudentBook{" +
                "prefix='" + prefix + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
