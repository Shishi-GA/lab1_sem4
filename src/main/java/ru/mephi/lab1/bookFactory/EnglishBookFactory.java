package ru.mephi.lab1.bookFactory;

import com.github.javafaker.Faker;
import ru.mephi.lab1.books.EnglishFictionBook;
import ru.mephi.lab1.books.EnglishStudentBook;
import ru.mephi.lab1.books.FictionBook;
import ru.mephi.lab1.books.StudentBook;
import java.util.List;
import java.util.Random;

public class EnglishBookFactory extends BookFactory implements EnglishStudentBookFactory, EnglishFictionBookFactory {

    @Override
    public StudentBook buildStudentBook() {
        Faker faker = new Faker();
        String ISBN = faker.bothify("###-#-##-#####-#");
        String bookName = faker.book().title();
        String author = faker.name().fullName();
        String university = faker.university().name();
        List<String> levels = List.of("bachelor", "master");
        String level = levels.get(new Random().nextInt(levels.size()));
        return new EnglishStudentBook(ISBN, bookName, author, university, level);
    }

    @Override
    public FictionBook buildFictionBook() {
        Faker faker = new Faker();
        String ISBN = faker.bothify("###-#-##-#####-#");
        String bookName = faker.book().title();
        String author = faker.name().fullName();
        List<Integer> ageLimits = List.of(16, 18, 21);
        int ageLimit = ageLimits.get(new Random().nextInt(ageLimits.size()));
        return new EnglishFictionBook(ISBN, bookName, author, ageLimit);
    }

}

