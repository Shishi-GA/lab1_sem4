package ru.mephi.lab1.books;

public class EnglishFictionBook extends FictionBook {

    private final int ageLimit;

    public EnglishFictionBook(String ISBN, String name, String author, int ageLimit) {
        super(ISBN, name, author);
        this.ageLimit = ageLimit;
    }

    @Override
    public String getName() {
        return  "\"" + super.name + "\", " + author + ", Age limit: " + ageLimit +", ISBN: " + ISBN;
    }

    @Override
    public String toString() {
        return "EnglishFictionBook{" +
                "ageLimit=" + ageLimit +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
