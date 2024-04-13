package ru.mephi.lab1.books;

public class RussianFictionBook extends FictionBook {

    private final int yearOfRealize;

    public RussianFictionBook(String ISBN, String name, String author, int yearOfRealize) {
        super(ISBN, name, author);
        this.yearOfRealize = yearOfRealize;
    }

    @Override
    public String getName() {
        return "\"" + super.name + "\", " + author + ", " + yearOfRealize + ", ISBN: " + ISBN;
    }



    @Override
    public String toString() {
        return "RussianFictionBook{" +
                "yearOfRealize=" + yearOfRealize +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
