package ru.mephi.lab1;

import ru.mephi.lab1.bookFactory.EnglishBookFactory;
import ru.mephi.lab1.bookFactory.RussianBookFactory;
import ru.mephi.lab1.books.Book;
import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.humanFactory.StudentFactory;
import ru.mephi.lab1.humanFactory.TeacherFactory;
import ru.mephi.lab1.library.Library;
import ru.mephi.lab1.library.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulator {

    private static final int NUMBER_OF_PEOPLE_IN_CATEGORY = 25;

    private static final int PEOPLE_CATEGORIES = 2;
    private static final int BOOKS_CATEGORIES = 4;
    private static final int TOTAL_NUMBER_OF_PEOPLE =
            NUMBER_OF_PEOPLE_IN_CATEGORY * PEOPLE_CATEGORIES;
    private static final int TOTAL_NUMBER_OF_BOOKS =
            NUMBER_OF_PEOPLE_IN_CATEGORY * BOOKS_CATEGORIES;
    private static final int NUMBER_OF_BOOKS = 10;
    private static final List<LibraryUser> libraryUsers = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();
    private static final Library library = new Library();

    private static void createLibraryUsers(TeacherFactory teacherFactory,
                                           StudentFactory studentFactory) {
        for (int i = 0; i < TOTAL_NUMBER_OF_PEOPLE; i++) {
            LibraryUser human;
            if (i < NUMBER_OF_PEOPLE_IN_CATEGORY) {
                human = teacherFactory.build();
            } else {
                human = studentFactory.build();
            }
            libraryUsers.add(human);
            Subscription subscription = new Subscription(human);
            human.setSubscription(subscription);
            library.addSubscription(human, subscription);
        }
    }
    private static void createBooks(EnglishBookFactory englishBookFactory,
                                    RussianBookFactory russianBookFactory) {
        for (int i = 0; i < TOTAL_NUMBER_OF_BOOKS; i++) {
            Book book;
            if (i % 4 == 0) {
                book = englishBookFactory.buildFictionBook();
            } else if (i % 4 == 1) {
                book = englishBookFactory.buildStudentBook();
            } else if (i % 4 == 2) {
                book = russianBookFactory.buildFictionBook();
            } else {
                book = russianBookFactory.buildStudentBook();
            }
            books.add(book);
            library.addBook(book, new Random().nextInt(NUMBER_OF_BOOKS));
        }
    }

    private static void distributeBooks() {
        for (int i = 0; i < TOTAL_NUMBER_OF_BOOKS; i++) {
            library.rentBook(books.get(new Random().nextInt(books.size())),
                    libraryUsers.get(new Random().nextInt(TOTAL_NUMBER_OF_PEOPLE)));
        }
    }


    public static void simulate() {

        TeacherFactory teacherFactory = new TeacherFactory();
        StudentFactory studentFactory = new StudentFactory();
        EnglishBookFactory englishBookFactory = new EnglishBookFactory();
        RussianBookFactory russianBookFactory = new RussianBookFactory();

        createLibraryUsers(teacherFactory, studentFactory);
        createBooks(englishBookFactory, russianBookFactory);
        distributeBooks();

        System.out.println(library);
        System.out.println();

        for (LibraryUser libraryUser : libraryUsers) {
            System.out.println(libraryUser);
        }

    }

    public static List<Book> getBooks() {
        return books;
    }

    public static List<LibraryUser> getLibraryUsers() {
        return libraryUsers;
    }

}
