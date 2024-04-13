package ru.mephi.lab1.bookFactory;

import ru.mephi.lab1.books.FictionBook;
import ru.mephi.lab1.books.StudentBook;

public abstract class BookFactory {

    public abstract StudentBook buildStudentBook();

    public abstract FictionBook buildFictionBook();

}
