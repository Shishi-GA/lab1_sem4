package ru.mephi.lab1.books;

public class EnglishStudentBook extends StudentBook {

    private final String university;
    private final String level;

    public EnglishStudentBook(String ISBN, String name, String author, String university, String level) {
        super(ISBN, name, author);
        this.university = university;
        this.level = level;
    }

    @Override
    public String getName() {
        return  "\"" + super.name + "\", " + author + ", " + university + ", " + level + ", ISBN: " + ISBN;
    }

    @Override
    public String toString() {
        return "EnglishStudentBook{" +
                "university='" + university + '\'' +
                ", level='" + level + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
